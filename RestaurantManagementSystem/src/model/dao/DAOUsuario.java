package model.dao;

import model.Usuario;

/**
 * @author yanri
 */
public class DAOUsuario {
    
    public boolean autenticaUsuario(Usuario usuario){
        return (usuario.getUsuario().equals("a") && usuario.getSenha().equals("a"));
    }
    
}
