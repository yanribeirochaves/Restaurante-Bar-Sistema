package model.dao;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;


/**
 * @author yanri
 */
public class UsuarioDAO {
    
    public void create(){
        
    }
    //Autentica o login do usuario através
    public Usuario authentication(String username, String senha){
        Usuario usuario = new Usuario();
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConection());
        PreparedStatement sql = null;
        
        try{
            sql = c.prepareStatement("SELECT id_usuario, id_acesso, id_mesa from usuario WHERE username LIKE ? and senha LIKE ?");
            sql.setString(1, username);
            sql.setString(2, senha);
            ResultSet rs = sql.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setIdMesa(rs.getInt("id_mesa"));
                usuario.setIdNivelAcesso(rs.getInt("id_acesso"));
            }
        }
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
        
        ConnectionDB.FecharConexao();
        return usuario;
    }
    public void update(){
        
    }
    public void delete(){
        
    }
}
