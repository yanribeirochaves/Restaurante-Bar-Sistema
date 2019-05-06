package controller.helper;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Table;
import model.Order;
import model.User;
import view.WaiterMenu;

/**
 * @author yanri
 */
public class HelperWaiterMenu {

    WaiterMenu view;
    public HelperWaiterMenu(WaiterMenu view) {
        this.view = view;
    }

    public void messageView(String message, String title, int type) {
        JOptionPane.showMessageDialog(null, message ,title,type);
    }
    
    //recebe a lista de mesas e o comboBox da view que elas serão carregadas
    public void fillTableComboBox(ArrayList<Table> tableList, DefaultComboBoxModel comboBoxModel) {
        comboBoxModel.removeAllElements();
        comboBoxModel.addElement("Todas as mesas");
        for(Table table : tableList){
            comboBoxModel.addElement(table);
        }
    }
    
    //retorna o novo usuario cliente da view que será inserido no banco
    public User getNewClientView(){
        User user = new User();
        user.setIdTable(Integer.parseInt(view.getComboBoxAvailableTable().getSelectedItem().toString()));
        user.setUsername(view.getTxtUsername().getText());
        user.setKey(view.getTxtKey().getText());
        user.setIdAccesLevel(3);//id de nivel de acesso de cliente no banco é 3
        return user;
    }

    //Preenche a tabela com uma lista de mesas
    public void fillTableTbl(ArrayList<Table> tableList) {
        DefaultTableModel tblModel = (DefaultTableModel) view.getTblTable().getModel();
        tblModel.setNumRows(0);

        //setar a largura das colunas
        view.getTblTable().getColumnModel().getColumn(0).setPreferredWidth(28);
        view.getTblTable().getColumnModel().getColumn(0).setWidth(28);
        view.getTblTable().getColumnModel().getColumn(0).setPreferredWidth(40);
        if (!tableList.isEmpty()) {
            for (Table table : tableList) {
                tblModel.addRow(new Object[]{
                    table.getIdTable(),
                    table.getStatusTable(),
                    table.getStatusWaitingOrder()
                });
            }
        }
    }
    
    //preenche a tabela de Pedidos com uma lista de pedidos
    public void fillOrderTbl (ArrayList<Order> orderList) {
        DefaultTableModel tblModel = (DefaultTableModel) view.getTblOrder().getModel();
        tblModel.setNumRows(0);
        
        //setar a largura das colunas
        view.getTblOrder().getColumnModel().getColumn(0).setPreferredWidth(28);
        view.getTblOrder().getColumnModel().getColumn(1).setPreferredWidth(80);
        view.getTblOrder().getColumnModel().getColumn(2).setPreferredWidth(30);
        if (!orderList.isEmpty()) {
            for (Order order : orderList) {
                tblModel.addRow(new Object[]{
                    order.getIdTable(),
                    order.getProduct(),
                    order.getQuantity(),
                    order.getObservation(),
                    order
                });
            }
        }
    }

    public void fillTextObservation(String observation) {
        if(observation != null)
            view.getTxtObservation().setText(observation);
        else
            view.getTxtObservation().setText("Nenhum observação feita");
    }
    
    /*
    esté método desabilita o botão de servir pedido e o botão cancelar pedido, caso o status do pedido 
    selecionado na tabela seja true, ou seja, o pedido ja foi servido
    e habilita caso seja false, ou seja, o pedido ainda está na fila e precisa ser entregue para o cliente.
    obs: os botões começarão desabilitados na view
    */
    public void setEnableBtnServeOrder(boolean selectedOrderStatus){
        if(selectedOrderStatus){
            view.getBtnServeOrder().setEnabled(false);
            view.getBtnCancelOrder().setEnabled(false);
        }
        else{
            view.getBtnServeOrder().setEnabled(true);
            view.getBtnCancelOrder().setEnabled(true);
        }
            
    }
}
