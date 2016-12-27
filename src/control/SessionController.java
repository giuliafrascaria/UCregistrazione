package control;

import boundary.*;
import entity.PrivateUser;

import javax.swing.*;
import java.util.Arrays;

public class SessionController
{

    private static SessionController ourInstance = new SessionController();
    protected UserFactory factory = UserFactory.getInstance();

    private GUI gui;

    public static SessionController getInstance()
    {
        return ourInstance;
    }

    protected SessionController()
    {
    }

    public void updateGUI(JFrame mainFrame, int frameN)
    {
        switch (frameN)
        {
            case 1:
                gui = new UserFormGUI(mainFrame);
                break;
            case 2:
                gui = new CorporateFormGUI(mainFrame);
                break;

        }
    }

    public boolean checkPWDFields(char[] p1, char[] p2)
    {
        return Arrays.equals(p1, p2);
        //in teoria per motivi di sicurezza dovrei reinizializzare gli array
    }

    public boolean checkEmptyFields(String text)
    {
        return text.equals("");
    }

    public boolean checkValidEmail(String text)
    {
        return text.contains("@");
    }
}

