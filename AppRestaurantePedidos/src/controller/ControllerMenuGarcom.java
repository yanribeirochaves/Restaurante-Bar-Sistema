package controller;

import connection.ConnectionDB;
import controller.helper.HelperMenuGarcom;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mesa;
import model.Usuario;
import model.dao.MesaDAO;
import model.dao.UsuarioDAO;
import view.MenuGarcom;

/**
 * @author yanri
 */
public class ControllerMenuGarcom {

    HelperMenuGarcom helper;
    public ControllerMenuGarcom(MenuGarcom view) {
        helper = new HelperMenuGarcom(view);
    }
    
    //este é o metodo que o funcionario diz para o sistema que alguma mesa está pronta para uso
    //para a mesa ser liberada, um usuario precisa ser criado para aquela mesa, e não pode ser repetido no banco de dados
    public void liberaMesa() {
        //busca o usuario no banco com o username
        Usuario usuario = helper.getUsuario();
        //caso já exista, não podera cadastrar um novo usuario com o mesmo username
        //no proprio banco, o username está como campo unique
        if (UsuarioDAO.isUsuarioExiste(usuario.getUsername())) {
            helper.mensagemBox("Usuário já existe", "Ops", 2);
        }
        else {
            boolean cadastrou = UsuarioDAO.cadastroUsuario(usuario);
            //se a cadastro do usuario cliente der certo, o status da mesa que o cliente escolheu deve mudar para true
            //Mensagem de mesa liberada tbm é enviado
            if(cadastrou){
                helper.mensagemBox("Mesa Liberada\nCliente já pode logar", "Nota", 1);
                MesaDAO.atualizaStatusMesa(usuario.getIdMesa());
                //atualiza comboBox de mesas disponíveis
                atualizaMesasDisponiveis();
                //Tabela de mesas com clientes deve ser atualizada
                atualizaTabelaMesas();
            }
        }
    }
    
    public void atualizaMesasDisponiveis(){
        //busca no banco as mesas que não tem clientes
        ArrayList<Mesa> listaMesas = MesaDAO.buscaMesas(false);
        //carrega as mesas disponiveis no comboBoc da tela
        if(listaMesas != null){
            helper.carregaMesas(listaMesas);
        }
        else{
            helper.mensagemBox(ConnectionDB.statusConnection(), "Erro", 0);
        }
    }
    
    //metodo que imprime na tela as dicas de como usar o app
    public void helpTela(){
        helper.mensagemBox("Para liberar uma mesa para um cliente, escolha\n"
                            + "o número da mesa e crie um username e senha","Ajuda ao usuário",3);
    }

    public void atualizaTabelaMesas() {
        //Buscar uma lista com as mesas que estão sendo usadas pelos clientes
        ArrayList<Mesa> listaMesas = MesaDAO.buscaMesas(true);
        //Exibir a lista na view, carregando as mesas na view, caso existam regisros
        if(listaMesas != null){
            helper.preencherTabela(listaMesas);
        }
        else{
            helper.mensagemBox(ConnectionDB.statusConnection(), "Erro", 0);
        }
    }
}
