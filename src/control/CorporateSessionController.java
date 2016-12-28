package control;

import boundary.*;
import entity.CorporateUser;

import javax.swing.*;


public class CorporateSessionController extends SessionController
{

    private static CorporateSessionController ourInstance = new CorporateSessionController();
    public static CorporateSessionController getInstance()
    {
        return ourInstance;
    }

    private GUI gui;

    private CorporateDBcontroller dbController = CorporateDBcontroller.getOurInstance();
    private CorporateUser user;

    private CorporateSessionController()
    {}

    @Override
    public void updateGUI(JFrame mainFrame, int frameN)
    {
        switch (frameN)
        {
            case 1:
                gui = new CorporateFormGUI(mainFrame);
                break;
            case 2:
                gui = new ConfirmGUI(mainFrame);
                break;
            case 3:
                gui = new CorporateProfileGUI(mainFrame, user.getName(), user.getOwner(), user.getEmail(), 0);
                break;
            case 4:
                gui = new AccessGUI(mainFrame);
                break;
        }
    }

    public void sendSignal() throws Exception
    {
        dbController.addUser(this.user);
    }

    public void saveData(String name, String email, String owner, String piva, char[] pwd)
    {
        user = factory.createCorporateUser();

        user.setName(name);
        user.setOwner(owner);
        user.setPiva(piva);
        user.setEmail(email);
        user.setPwd(pwd);
    }
}
