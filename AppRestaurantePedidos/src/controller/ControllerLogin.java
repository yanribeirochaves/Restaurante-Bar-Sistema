package controller;

import connection.ConnectionDB;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Usuario;
import model.dao.UsuarioDAO;
import view.Login;

/**
 * @author yanri
 */
public class ControllerLogin {

    Login view;
    Connection c;

    public ControllerLogin(Login view) {
        this.view = view;
    }

    public void loginUsuario() {
        
        UsuarioDAO usuarioD = new UsuarioDAO();
        try {
            Usuario usuario = usuarioD.authentication(view.getTxtUser(), view.getTxtSenha());
            //consultar o banco de dados para saber qual id representa cada nivel de acesso
            if (usuario.getIdNivelAcesso() == 1) {
                JOptionPane.showMessageDialog(null, "Garçom logado abrir tela do garçom");
            } else if (usuario.getIdNivelAcesso()== 2) {
                JOptionPane.showMessageDialog(null, "Gerente logado abrir tela do gerente");
            } else if (usuario.getIdNivelAcesso() == 3) {
                JOptionPane.showMessageDialog(null, "Cliente logado abrir tela do cliente");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos. ");
            }
        } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, ConnectionDB.statusConection() + "\n\n" + e, "Erro", 0);
        }
    }
}
