package database;

/**
 * Created by giogge on 18/12/16.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource
{


        private String dbURI = "jdbc:postgresql://localhost:5432/dada";
        private String user = "postgres";
        private String password = "postgres";

        public Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(dbURI,user, password);
            return connection;
        }
}

