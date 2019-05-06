package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 * @author yanri
 */
public class UserDAO {
    
    //insere um novo usuario no banco
    public static boolean createUser(User user){
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("INSERT into usuario (username, senha, id_acesso, id_mesa) values (?,?,?,?)");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, user.getUsername());
            sql.setString(2, user.getKey());
            sql.setInt(3, user.getIdAccesLevel());
            sql.setInt(4, user.getIdTable());
            
            //executa o código sql
            sql.executeUpdate();
            //fecha a conexão
            sql.close();
            c.close();
            ConnectionFactory.closeConnection();
            return true;
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
        }
        return false;
    }
    
    //Autentica o login do usuario através buscando o username e a senha no banco
    //e retornando um usuario com todos os atributos
    public static User readAuthenticatedUser(String username, String key){
        User user = new User();
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT id_usuario, username, senha, id_acesso, id_mesa from usuario WHERE username LIKE ? and senha LIKE ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, username);
            sql.setString(2, key);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //caso exista um registro com os parâmetros passados, salva o registro no objeto usuario e retorna o mesmo
            //caso contrario, retorna null
            if(rs.next()){
                user.setId(rs.getInt("id_usuario"));
                user.setUsername(rs.getString("username"));
                user.setKey(rs.getString("senha"));
                user.setIdTable(rs.getInt("id_mesa"));
                user.setIdAccesLevel(rs.getInt("id_acesso"));
            }
            else{
                return null;
            }
            sql.close();
            c.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
        return user;
    }
    
    //necessario antes de cadastrar um novo usuario, o username não pode ser igual ao de outro registro
    //no proprio banco o campo está como unique
    public static boolean isUserExists(String username){
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT id_usuario from usuario WHERE username LIKE ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setString(1, username);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //caso exista um registro com o username passado, retorna true
            //caso contrario, retorna false;
            if (rs.next()) {
                sql.close();
                c.close();
                ConnectionFactory.closeConnection();
                return true;
            }
        }
        //se der erro de SQL, retorna false
        catch(SQLException e){
            System.err.println(ConnectionFactory.statusConnection());
            System.err.println(e);
        }
        return false;
    }
    
    public static void update(){
        
    }
    public static void delete(){
        
    }
}
