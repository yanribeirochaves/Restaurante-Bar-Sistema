package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table;

/**
 * @author yanri
 */
public class TableDAO {
    public static void create(){
        
    }
    //busca a lista de mesas de acordo com o status da mesa, true para mesa com cliente e false para mesa vazia
    public static ArrayList<Table> readTablesForStatus(boolean statusTable){
        ArrayList<Table> tableList = new ArrayList();
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT * from mesas WHERE status_mesa = ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setBoolean(1, statusTable);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //Salva todos os registros em um objeto mesa, e salva o objeto em um arraylist
            //se não tiver registro, retorna uma lista vazia
            while(rs.next()){
                Table table = new Table();
                table.setIdTable(rs.getInt("id_mesa"));
                table.setStatusTable(rs.getBoolean("status_mesa"));
                table.setStatusWaitingOrder(rs.getBoolean("status_aguardando_pedido"));
                tableList.add(table);
            }
            //fecha a conexão
            c.close();
            sql.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
        catch(NullPointerException e){
            System.err.println(e);
            System.err.println(ConnectionFactory.statusConnection());
            return null;
        }
        return tableList;
    }
   
    /*Este método muda o status da mesa de acordo com o id e o status passados nos parâmetros
    quando uma mesa é liberada para um cliente, o status dela muda para true (mesa ocupada)
    quando o cliente paga e sai da mesa, o status muda para false (mesa desocupada)
    */
    public static void updateStatusTable(int idTable, boolean newStatusTable){
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("UPDATE mesas SET status_mesa = ? WHERE id_mesa = ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setBoolean(1, newStatusTable);
            sql.setInt(2, idTable);
            
            //executa o código sql
            sql.executeUpdate();
            //fecha a conexão
            sql.close();
            c.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException e){
            System.err.println(e);
        }
    }
    public static void delete(){
        
    }
}
