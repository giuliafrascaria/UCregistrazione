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
            case 2:
                gui = new ConfirmGUI(mainFrame);
        }
    }

    public boolean checkFields(JPasswordField p1, JPasswordField p2)
    {
        return p1.getPassword() == p2.getPassword();
    }
}
