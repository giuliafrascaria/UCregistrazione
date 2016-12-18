package control;


import database.DataSource;
import entity.PrivateUser;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DatabaseController
{
    private DataSource dataSource;
    private static DatabaseController ourInstance = new DatabaseController();
    public static DatabaseController getInstance() {
        return ourInstance;
    }

    private DatabaseController()
    {
        this.dataSource = new DataSource();
    }


    public boolean checkUser(String mail) throws Exception
    {
        PrivateUser user;
        System.out.println("sto per cercare l'utente");
        user = this.findByPrimaryKey(mail);
        System.out.println("ricerca finita");
        return user != null;
    }

    private PrivateUser findByPrimaryKey(String userID) throws Exception
    {
        Connection connection = null;
        PreparedStatement statement = null;
        PrivateUser user = null;
        ResultSet result = null;
        final String query = "select * from USERS.Privato where EMAIL=?";


        try{
            connection = this.dataSource.getConnection();

            statement = connection.prepareStatement(query);
            statement.setString(1, userID);
            result = statement.executeQuery();

            if (result.next()) {
                if (user == null) {
                    user = new PrivateUser();
                    user.setEmail(result.getString("EMAIL"));
                    user.setName(result.getString("NOME"));
                }
            } else {
                return null;
            }
        }finally{
            // release resources
            if(result != null){
                result.close();
            }
            // release resources
            if(statement != null){
                statement.close();
            }
            if(connection  != null){
                connection.close();
            }
        }
        return user;
    }
}
