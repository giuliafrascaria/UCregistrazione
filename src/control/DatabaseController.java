package control;


import javax.sql.DataSource;
import javax.swing.*;


/**
 * Created by giogge on 05/12/16.
 */
public class DatabaseController
{
    private DataSource dataSource;

    private static DatabaseController ourInstance = new DatabaseController();

    public static DatabaseController getInstance() {
        return ourInstance;
    }

    private DatabaseController()
    {

    }

    public boolean checkUser(String mail)
    {
        return false;
    }
}
