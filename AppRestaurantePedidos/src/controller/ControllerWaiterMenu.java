package controller;

import connection.ConnectionFactory;
import controller.helper.HelperWaiterMenu;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Table;
import model.Order;
import model.User;
import model.dao.TableDAO;
import model.dao.OrderDAO;
import model.dao.UserDAO;
import view.WaiterMenu;

/**
 * @author yanri
 */
public class ControllerWaiterMenu {

    HelperWaiterMenu helper;
    WaiterMenu view;
    public ControllerWaiterMenu(WaiterMenu view) {
        helper = new HelperWaiterMenu(view);
        this.view = view;
    }
    
    //este é o metodo que o funcionario diz para o sistema que a mesa escolhida está pronta para uso
    //para a mesa ser liberada para o cliente, um usuario cliente precisa ser criado para aquela mesa e não pode ser repetido no banco de dados
    public void readyTableToUse() {
        //indice 0 não corresponde a uma mesa e sim a uma String
        if (view.getComboBoxAvailableTable().getSelectedIndex() == 0) {
            helper.messageView("Selecione uma mesa", "Ops", 2);
        }
        else {
            //busca o user no banco com o username
            User user = helper.getNewClientView();
            //caso já exista, não podera cadastrar um novo user com o mesmo username
            //no proprio banco, o username está como campo unique
            if (UserDAO.isUserExists(user.getUsername())) {
                helper.messageView("Usuário já existe", "Ops", 2);
            } else {

                //cadastro do usuario no banco
                boolean register = UserDAO.createUser(user);
                //se a cadastro do usuario cliente der certo, o status da mesa que o cliente escolheu deve mudar para true
                //Mensagem de mesa liberada tbm é enviado
                if (register) {
                    helper.messageView("Mesa Liberada\nCliente já pode logar", "Nota", 1);
                    //Atualiza o status da mesa para true, ou seja, a mesa agora está ocupada
                    TableDAO.updateStatusTable(user.getIdTable(),true);
                    //atualiza comboBox de mesas disponíveis
                    updateAvailableTableComboBox();
                    //atualiza comboBox de mesas ocupadas
                    updateOccupiedTableComboBox();
                    //Tabela de mesas com clientes deve ser atualizada
                    updateTablesTbl();
                }
                else{
                    helper.messageView("Aconteceu um erro no cadastro do cliente", "Erro", 0);
                }
            }
        }
    }
    
    //atualiza comboBox de mesas disponíveis na view
    public void updateAvailableTableComboBox(){
        //busca no banco as mesas que não tem clientes
        ArrayList<Table> tableList = TableDAO.readTablesForStatus(false);
        //carrega as mesas disponiveis no comboBox da tela
        if(tableList != null){
            helper.fillTableComboBox(tableList, (DefaultComboBoxModel)view.getComboBoxAvailableTable().getModel());
        }
        else{
            helper.messageView(ConnectionFactory.statusConnection(), "Erro", 0);
        }
    }
    
    //atualiza comboBox de mesas ocupadas na view
    public void updateOccupiedTableComboBox(){
        //busca no banco as mesas que não tem clientes
        ArrayList<Table> listaMesas = TableDAO.readTablesForStatus(true);
        //carrega as mesas disponiveis no comboBoc da tela
        if(listaMesas != null){
            helper.fillTableComboBox(listaMesas, (DefaultComboBoxModel)view.getComboBoxOccupiedTable().getModel());
            
        }
        else{
            helper.messageView(ConnectionFactory.statusConnection(), "Erro", 0);
        }
    }
    
    //metodo que imprime na tela as dicas de como usar o app
    public void helpUseScreenTables(){
        helper.messageView("Para liberar uma mesa para um cliente, escolha\n"
                            + "o número da mesa e crie um username e senha","Ajuda ao usuário",3);
    }

    //atualiza a tabela de mesas na view
    public void updateTablesTbl() {
        //Busca uma lista com as mesas que estão sendo usadas pelos clientes
        ArrayList<Table> TableList = TableDAO.readTablesForStatus(true);
        //Exibir a lista na tabela da view, carregando as mesas na view, caso existam regisros
        if(TableList != null){
            helper.fillTableTbl(TableList);
        }
        else{
            helper.messageView(ConnectionFactory.statusConnection(), "Erro", 0);
        }
    }
    
    //atualiza a tabela de pedidos da view
    public void updateOrderTbl() {
        //retorna qual radio do filtro da tabela da view está selecionado
        int filterOption = checkStatusOrderFilter();
        ArrayList<Order> orderList = null;
        Table table = null;
        //caso o indice da mesa seja diferente
        if(view.getComboBoxOccupiedTable().getSelectedIndex() != 0){
            table = (Table)view.getComboBoxOccupiedTable().getSelectedItem();
        }
        //caso um mesa seja selecionada passando valor diferente de null, a busca também será feita pelo id
        switch(filterOption){
            case 0://filtro de tabela para pedidos ainda em fila
                orderList = OrderDAO.readOrdersForStatusAndIdTable(false, table);
                break;
            case 1://filtro de tabela para pedidos entregues
                orderList = OrderDAO.readOrdersForStatusAndIdTable(true, table);
                break;
            case 2://filtro de tabela para todos os pedidos
                orderList = OrderDAO.readOrdersForId(table);
                break;
        }
        
        if(orderList != null){
            helper.fillOrderTbl(orderList);
        }
        else{
            helper.messageView(ConnectionFactory.statusConnection(), "Erro", 0);
        }
    }
    
    //identifica qual botao de radio esta selecionado como filtro na view
    public int checkStatusOrderFilter(){
        if(view.getRadioPendingOrder().isSelected()){
            return 0;
        }
        else if(view.getRadioDeliveredOrder().isSelected()){
            return 1;
        }
        else{
            return 2;
        }
    }
    
    //todasas ações que dependem da seleção de uma linha na tabela serão chamadas nesse método
    public void selectItemTableOrder(){
        int indexRow = view.getTblOrder().getSelectedRow(); //pega o indice da linha selecionada na tabela
        
        //pega o campo de observação do pedido selecionado na tabela e mostra no textArea de observação da view
        String selectedObservationOrder = (String) view.getTblOrder().getValueAt(indexRow, 3);
        helper.fillTextObservation(selectedObservationOrder);
        
        //pega o status do pedido e de acordo com ele, habilita ou desabiita os botões de servir ou cancelar o pedido
        Order selectedOrder = (Order) view.getTblOrder().getValueAt(indexRow, 4);
        helper.setEnableBtnServeOrder(selectedOrder.isStatusOrder());
    }
    
    /*
    este método passa o status do pedido de true para false, pois é quando o garçom informa o sistema que ele vai levar
    o pedido para o cliente na mesa, impossibilitano outro garçom e tentar levar o mesmo pedido para a mesa
    */
    public void serveOrder (){
        
    }
    

}
