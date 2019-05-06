package controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.User;
import model.dao.UserDAO;
import view.Login;
import view.WaiterMenu;

/**
 * @author yanri
 */
public class ControllerLogin {

    Login view;
    Connection c;

    public ControllerLogin(Login view) {
        this.view = view;
    }

    public void userAuthentication() {
        try {
            //busca o usuario no banco com o username e senha dos campos de texto da tela
            User usuario = UserDAO.readAuthenticatedUser(view.getTxtUser(), view.getTxtKey());
            //obs: consulte o banco de dados para saber qual id representa cada nivel de acesso
            //Chamada da interface pra cada tipo de usuario
            switch (usuario.getIdAccesLevel()) {
                case 1:
                    WaiterMenu menuGarcom = new WaiterMenu();
                    menuGarcom.setVisible(true);
                    view.dispose();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Gerente logado abrir tela do gerente");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Cliente logado abrir tela do cliente");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos.");
                    break;
            }
        }
        catch (NullPointerException e) {
            //caso o usuario venha com valor null, algo de errado aconteceu na conexao com o banco
            JOptionPane.showMessageDialog(null, ConnectionFactory.statusConnection() + "\n\n" + e, "Erro", 0);
        }
    }
}
