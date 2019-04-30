package model.dao;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * @author yanri
 */
public class UsuarioDAO {
    
    public static boolean cadastroUsuario(Usuario usuario){
        //abre a conexao com o banco
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("INSERT into usuario (username, senha, id_acesso, id_mesa) values (?,?,?,?)");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, usuario.getUsername());
            sql.setString(2, usuario.getSenha());
            sql.setInt(3, usuario.getIdNivelAcesso());
            sql.setInt(4, usuario.getIdMesa());
            
            //executa o código sql
            sql.executeUpdate();
            sql.close();
            ConnectionDB.FecharConexao();
            return true;
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
        }
        return false;
    }
    
    //Autentica o login do usuario através buscando o username e a senha no banco
    //e retornando um usuario com os atributos completos
    public static Usuario buscaUsuario(String username, String senha){
        Usuario usuario = new Usuario();
        //abre a conexao com o banco
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT id_usuario, username, senha, id_acesso, id_mesa from usuario WHERE username LIKE ? and senha LIKE ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, username);
            sql.setString(2, senha);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //caso exista um registro com os valores pedidos, salva o registro no objeto usuario
            //caso contrario, o usuario irá ser retornado com todos os atributos com valores null
            if(rs.next()){
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setIdMesa(rs.getInt("id_mesa"));
                usuario.setIdNivelAcesso(rs.getInt("id_acesso"));
            }
            sql.close();
            ConnectionDB.FecharConexao();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
        return usuario;
    }
    
    //necessario antes de cadastrar um novo usuario, o username não pode ser igual ao de outro registro
    //no proprio banco o campo está como unique
    public static boolean isUsuarioExiste(String username){
        boolean existe = false;
        //abre a conexao com o banco
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT id_usuario from usuario WHERE username LIKE ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, username);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //caso exista um registro com os valores pedidos, salva o registro no objeto usuario
            //caso contrario, o usuario irá ser retornado com todos os atributos com valores null
            if(rs.next()){
                existe = true;
            }
            sql.close();
            ConnectionDB.FecharConexao();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
            existe = false;
        }
        //se der erro de SQL, retorna null
        catch(NullPointerException e){
            System.err.println(e);
            System.err.println(ConnectionDB.statusConnection());
            existe = false;
        }
        return existe;
    }
    
    public static void update(){
        
    }
    public static void delete(){
        
    }
}
