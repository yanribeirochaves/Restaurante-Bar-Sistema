package controller.helper;

import javax.swing.JOptionPane;
import model.Usuario;
import view.Login;

/**
 * @author yanri
 */
public class HelperLogin {

    private final Login view;
    
    public HelperLogin(Login view) {
        this.view = view;
    }

    public Usuario obterModel() {
        String nomeUsuario = view.getTxtUsuario();
        String senha = view.getTxtSenha();
        Usuario usuario = new Usuario(nomeUsuario, senha);
        return usuario;
    }
    
    public void placeHolderUsuario(){
        if(view.getTxtUsuario().equals("User")){
            view.setTxtUsuario("");
        }
    }    
    
    public void placeHolderSenha(){
        if(view.getTxtUsuario().equals("senha")){
            view.setTxtSenha("");
        }
    }

    public void aviso(String aviso) {
        JOptionPane.showMessageDialog(null, aviso);
    }

    public void exit() {
        view.dispose();
    }
}
