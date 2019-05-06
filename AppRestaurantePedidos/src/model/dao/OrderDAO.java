package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table;
import model.Order;

/**
 * @author yanri
 */
public class OrderDAO {
    
    /*
    Este método retorna os pedidos que foram feitos por uma mesa pelo status do pedido.
    --> status=true, para pedidos entregue; --> status=false, para pedidos ainda na fila
    Caso objeto mesa passado como parâmetro não seja null, também será usada a busca pelo Id
    */
    public static ArrayList<Order> readOrdersForStatusAndIdTable(boolean status, Table table){
        ArrayList<Order> orderList = new ArrayList();
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            //caso o valor passado pela mesa seja null, a busca só será feita pelo status do pedido
            //caso contrario, a busca será feita pelo status e pelo id da mesa
            if(table == null){
                sql = c.prepareStatement("SELECT * from pedidos WHERE status_pedido LIKE ?");
                //parametros que vão no lugar do '?' no sql, respectivamente
                sql.setBoolean(1, status);
            }
            else
            {
                sql = c.prepareStatement("SELECT * from pedidos WHERE status_pedido LIKE ? and id_mesa LIKE ?");
                //parametros que vão no lugar do '?' no sql, respectivamente
                sql.setBoolean(1, status);
                sql.setInt(2, table.getIdTable());
            }
            
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            //caso não exista registro, a lista retornará vazia
            while(rs.next()){
                Order order = new Order();
                order.setIdOrder(rs.getInt("id_pedido"));
                order.setIdTable(rs.getInt("id_mesa"));
                order.setProduct(ProductDAO.readProductForId(rs.getInt("id_produto")));
                order.setQuantity(rs.getInt("quantidade_produto"));
                order.setObservation(rs.getString("observacao"));
                order.setStatusOrder(rs.getBoolean("status_pedido"));
                orderList.add(order);
            }
            sql.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException | NullPointerException e){
            System.err.println(e);
            return null;
        }
        return orderList;
    }
    /*este método retorna todos os pedidos que foram feitos por uma mesa
    buscando pelo id, caso o objeto mesa seja null, busca todos os pedidos*/
    public static ArrayList<Order> readOrdersForId(Table table){
        ArrayList<Order> orderList = new ArrayList();
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql;
        
        //tenta executar o código sql
        try{
            //caso o valor passado pela mesa seja null, a buscara todos os pedidos de todas as mesas
            //caso contrario, a busca de pedidos será feita pelo id da mesa
            if(table == null){
                sql = c.prepareStatement("SELECT * from pedidos");
            }
            else{
                sql = c.prepareStatement("SELECT * from pedidos WHERE id_mesa LIKE ?");
                //parametros que vão no lugar do '?' no sql, respectivamente
                sql.setInt(1, table.getIdTable());
            }            
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()){
                Order order = new Order();
                order.setIdOrder(rs.getInt("id_pedido"));
                order.setIdTable(rs.getInt("id_mesa"));
                order.setProduct(ProductDAO.readProductForId(rs.getInt("id_produto")));
                order.setQuantity(rs.getInt("quantidade_produto"));
                order.setObservation(rs.getString("observacao"));
                order.setStatusOrder(rs.getBoolean("status_pedido"));
                orderList.add(order);
            }
            sql.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException | NullPointerException e){
            System.err.println(e);
            return null;
        }
        return orderList;
    }
}
