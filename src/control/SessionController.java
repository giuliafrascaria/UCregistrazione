package control;

import boundary.ConfirmGUI;
import boundary.GUI;
import boundary.ProfileGUI;
import boundary.UserFormGUI;
import entity.PrivateUser;

import javax.swing.*;
import java.util.Arrays;

public class SessionController
{

    private static SessionController ourInstance = new SessionController();
    private UserFactory factory = UserFactory.getInstance();
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
        switch (frameN)
        {
            case 1:
                gui = new UserFormGUI(mainFrame);
                break;
            case 2:
                gui = new ConfirmGUI(mainFrame);
                break;
            case 3:
                gui = new ProfileGUI(mainFrame, user.getName(), user.getEmail(), user.getEmail());
                break;
            case 4:
                //gui = new CorporateFormGUI(mainFrame)
        }
    }

    public void saveData(String name, String email, String surname, char[] pwd)
    {
        user = factory.createUser();

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPwd(pwd);
    }

    public void addUser() throws Exception
    {
        dbController.addUser(this.user);

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

