package control;

/**
 * Created by giogge on 05/12/16.
 */
public class MailController
{
    private static MailController ourInstance = new MailController();

    public static MailController getInstance() {
        return ourInstance;
    }

    private MailController()
    {

    }

    public void sendMail()
    {

    }
}
