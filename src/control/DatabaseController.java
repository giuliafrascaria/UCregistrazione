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

    protected DatabaseController()
    {
        this.dataSource = new DataSource();
    }

    private class DatabaseAccess implements Runnable
    {
        @Override
        public void run()
        {

        }
    }


    public boolean checkUser(String mail) throws Exception
    {
        PrivateUser user;
        System.out.println("sto per cercare l'utente");
        user = this.findByPrimaryKey(mail);
        System.out.println("ricerca finita");
        return user == null;
    }

    private PrivateUser findByPrimaryKey(String userID) throws Exception
    {

        Connection connection = null;
        PreparedStatement statement = null;
        PrivateUser user = null;
        ResultSet result = null;
        final String query = "select * from USERS.UtenteRegistrato where EMAIL=?";
        //final String query = "select * from USERS.UtenteRegistrato";


        try{
            connection = this.dataSource.getConnection();

            statement = connection.prepareStatement(query);
            statement.setString(1, userID);
            result = statement.executeQuery();

            if (result.next()) {
                if (user == null) {
                    user = new PrivateUser();
                    user.setEmail(result.getString("EMAIL"));
                    //user.setName(result.getString("NOME"));
                    System.out.println(user.getEmail());
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

    void addUser(PrivateUser newUser) throws Exception
    {

        Connection connection = null;
        Connection connection2 = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        final String insert = "INSERT INTO USERS.UtenteRegistrato(EMAIL, PASSWORD) values (?,?)";
        final String insert2 = "INSERT INTO USERS.Privato(NOME, COGNOME, EMAIL) values (?,?,?)";
        try
        {
            connection = this.dataSource.getConnection();


            statement = connection.prepareStatement(insert);
            statement.setString(1, newUser.getEmail());
            statement.setString(2, String.valueOf((newUser.getPwd())));

            statement.executeUpdate();


        }
        finally
        {
            // release resources
            if(statement != null)
            {
                statement.close();
            }
            if(connection  != null)
            {
                connection.close();
            }
        }
        try
        {
            connection2 = this.dataSource.getConnection();

            statement2 = connection2.prepareStatement(insert2);
            statement2.setString(1, newUser.getName());
            statement2.setString(2, newUser.getSurname());
            statement2.setString(3, newUser.getEmail());

            statement2.executeUpdate();
        }
        finally
        {
            if(statement2 != null)
            {
                statement2.close();
            }

            if(connection2  != null)
            {
                connection.close();
            }
        }


    }

}
