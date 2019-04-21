package controller;

import controller.helper.HelperLogin;
import model.Usuario;
import model.dao.DAOUsuario;
import view.Login;
import view.MenuPrincipal;

/**
 * @author yanri
 */
public class ControllerLogin {
    //objeto que cuida das interações na interface
    private final HelperLogin helper;

    public ControllerLogin(Login view) {
        helper = new HelperLogin(view);
    }
    
    public void acessar(){
        Usuario usuario = helper.obterModel();
        DAOUsuario daoUsuario = new DAOUsuario();
        if(daoUsuario.autenticaUsuario(usuario)){
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
            helper.exit();
        }
        else{
            helper.aviso("Usuario incorreto");
        }
    }

    public void placeHolderUsuario() {
        helper.placeHolderUsuario();
    }
    
    public void placeHolderSenha() {
        helper.placeHolderSenha();
    }
    
}
