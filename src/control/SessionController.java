package control;

import boundary.ConfirmGUI;
import boundary.GUI;
import boundary.UserFormGUI;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

/**
 * Created by giogge on 05/12/16.
 */
public class SessionController {
    private static SessionController ourInstance = new SessionController();
    private GUI gui;

    public static SessionController getInstance()
    {
        return ourInstance;
    }

    private SessionController()
    {
    }

    public void updateGUI(JFrame mainFrame, int frameN)
    {
        switch (frameN) {
            case 1:
                gui = new UserFormGUI(mainFrame);
                System.out.print(frameN);
            case 2:
                gui = new ConfirmGUI(mainFrame);
                System.out.print(frameN);
            default:
                break;
        }
    }

    public boolean checkPWDFields(char[] p1, char[] p2)
    {
        return p1 == p2;
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

