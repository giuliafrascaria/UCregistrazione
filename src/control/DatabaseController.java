package control;

/**
 * Created by giogge on 05/12/16.
 */
public class DatabaseController
{
    private static DatabaseController ourInstance = new DatabaseController();

    public static DatabaseController getInstance() {
        return ourInstance;
    }

    private DatabaseController()
    {
    }

    public boolean checkUser()
    {
        return false;
    }
}
