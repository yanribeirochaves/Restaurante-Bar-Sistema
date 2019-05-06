package connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yanri
 */
public class ConnectionFactory {

    private static String status;

    public ConnectionFactory() {
    }

    //Método de Conexão
    public static java.sql.Connection getConnectionDB() {

        Connection connection = null;
        try {
            // Configurando a nossa conexão com um banco de dados//
            String serverIP = "localhost"; //ip do servidor do BD
            String mydatabase = "restaurante"; //nome do banco de dados
            String url = "jdbc:mysql://" + serverIP + "/" + mydatabase;
            String username = "root"; //nome do usuário de BD
            String password = "xambra"; //senha de acesso

            connection = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            connection = null;
        }
        //Testa sua conexão//  
        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");

        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        return connection;
    }

    //Método que retorna o status da sua conexão//
    public static String statusConnection() {
        return status;
    }

    //Método que fecha sua conexão//
    public static boolean closeConnection() {

        try {
            ConnectionFactory.getConnectionDB().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection restartConnection() {
        closeConnection();
        return ConnectionFactory.getConnectionDB();
    }

}
