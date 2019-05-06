package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Product;

/**
 * @author yanri
 */
public class ProductDAO {
    
    public static Product readProductForId(int idTable){
        Product product = new Product();
        //abre a conexao com o banco
        Connection c = ConnectionFactory.getConnectionDB();
        System.out.println(ConnectionFactory.statusConnection());
        PreparedStatement sql = null;
        
        //tenta executar o código sql
        try{
            sql = c.prepareStatement("SELECT * from produtos WHERE id_produto LIKE ?");
            //parametros que vão no lugar do '?' no sql, respectivamente
            sql.setInt(1, idTable);
            //executa o código sql
            ResultSet rs = sql.executeQuery();
            
            if(rs.next()){
                product.setIdProduct(rs.getInt("id_produto"));
                product.setName(rs.getString("nome"));
                product.setType(rs.getString("tipo"));
                product.setDescription(rs.getString("descricao"));
                product.setWeight(rs.getFloat("peso"));
                product.setVolume(rs.getFloat("volume"));
                product.setUnits(rs.getInt("unidades"));
                product.setPrice(rs.getFloat("valor"));
            }
            else{
                return null;
            }
            sql.close();
            ConnectionFactory.closeConnection();
        }
        //se der erro de SQL, retorna null
        catch(SQLException | NullPointerException e){
            System.err.println(e);
            return null;
        }
        return product;
    }
}
