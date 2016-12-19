package control;

import boundary.ConfirmGUI;
import boundary.GUI;
import boundary.UserFormGUI;
import entity.PrivateUser;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.util.Arrays;


public class SessionController
{

    private static SessionController ourInstance = new SessionController();
    private GUI gui;
    private PrivateUser user;
    private DatabaseController dbController = DatabaseController.getInstance();

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
            default:
                break;
        }
    }

    public void saveData(String name, String email, char[] pwd)
    {
        user = new PrivateUser();
        user.setName(name);
        user.setEmail(email);
        user.setPwd(pwd);

    }

    public void addUser() throws Exception
    {
        dbController.addUser(this.user);
    }

    public void updateMailGUI(JFrame mainFrame)
    {
        gui = new ConfirmGUI(mainFrame);
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

