package model.dao;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Mesa;

/**
 * @author yanri
 */
public class MesaDAO {
    public static void create(){
        
    }
    //busca a lista de mesas de acordo com o status, true para mesa com cliente e false para mesa vazia
    public static ArrayList<Mesa> buscaMesas(boolean status){
        ArrayList<Mesa> listaMesas = new ArrayList();
        //abre a conexao com o banco
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT id_mesa, status_mesa from mesas WHERE status_mesa = ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setBoolean(1, status);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //Salva todos os registros em um objeto mesa, e salva o objeto em um arraulist de objetos
            //caso contrario, o usuario irá ser retornado com todos os atributos com valores null
            while(rs.next()){
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("id_mesa"));
                mesa.setStatusMesa(rs.getBoolean("status_mesa"));
                listaMesas.add(mesa);
            }
            sql.close();
            ConnectionDB.FecharConexao();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
        catch(NullPointerException e){
            System.err.println(e);
            System.err.println(ConnectionDB.statusConnection());
            return null;
        }
        
        return listaMesas;
    }
    
    public static void atualizaStatusMesa(int idMesa){
        //abre a conexao com o banco
        Connection c = ConnectionDB.getConexaoMySQL();
        System.out.println(ConnectionDB.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("UPDATE mesas SET status_mesa = true WHERE id_mesa = ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setInt(1, idMesa);
            
            //executa o código sql
            sql.executeUpdate();
            sql.close();
            ConnectionDB.FecharConexao();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
        }
    }
    public static void delete(){
        
    }
}
