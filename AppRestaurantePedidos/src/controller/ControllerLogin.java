package controller;

import connection.ConnectionDB;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Usuario;
import model.dao.UsuarioDAO;
import view.Login;
import view.MenuGarcom;

/**
 * @author yanri
 */
public class ControllerLogin {

    Login view;
    Connection c;

    public ControllerLogin(Login view) {
        this.view = view;
    }

    public void autenticacaoUsuario() {
        try {
            //busca o usuario no banco com o username e senha dos campos de texto da tela
            Usuario usuario = UsuarioDAO.buscaUsuario(view.getTxtUser(), view.getTxtSenha());
            //obs: consulte o banco de dados para saber qual id representa cada nivel de acesso
            //Chamada da interface pra cada tipo de usuario
            switch (usuario.getIdNivelAcesso()) {
                case 1:
                    MenuGarcom menuGarcom = new MenuGarcom();
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
            JOptionPane.showMessageDialog(null, ConnectionDB.statusConnection() + "\n\n" + e, "Erro", 0);
        }
    }
}
