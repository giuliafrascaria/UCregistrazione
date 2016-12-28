package control;

import boundary.*;
import entity.PrivateUser;

import javax.swing.*;


public class PrivateSessionController extends SessionController
{
    private static PrivateSessionController ourInstance = new PrivateSessionController();
    public static PrivateSessionController getInstance() { return ourInstance; }

    private GUI gui;

    private PrivateDBcontroller dbController = PrivateDBcontroller.getOurInstance();
    private PrivateUser user;

    private PrivateSessionController(){}

    @Override
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
                gui = new PrivateProfileGUI(mainFrame, user.getName(), user.getEmail(), user.getEmail());
                break;
            case 4:
                gui = new AccessGUI(mainFrame);
                break;
        }
    }

    public void addUser() throws Exception
    {
        dbController.addUser(this.user);

    }

    public void saveData(String name, String email, String surname, char[] pwd)
    {
        user = factory.createUser();

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPwd(pwd);
    }
}
