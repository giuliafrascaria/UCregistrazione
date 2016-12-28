package boundary;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 27/12/16.
 */
public class CorporateProfileGUI implements ProfileGUI
{
    private JFrame mainFrame = new JFrame();

    private JLabel nameLabel;
    private JLabel ownerLabel;
    private JLabel emailLabel;
    private JLabel welcome;
    private JLabel statusLabel;

    private JLabel corporateName;
    private JLabel ownerName;
    private JLabel corporateEmail;

    private JPanel formPanel, globalPanel, welcomePanel, statusPanel;

    public CorporateProfileGUI(JFrame mainFrame, String name, String owner, String mail, int status)
    {

        this.mainFrame = mainFrame;

        globalPanel = new JPanel();
        globalPanel.setLayout(new GridLayout(3,1));

        welcomePanel = new JPanel();

        welcome = new JLabel("\n\nBENVENUTO IN DaDa!!! il tuo profilo risulta al momento:");
        welcomePanel.add(welcome);

        globalPanel.add(welcomePanel);

        statusPanel = new JPanel();
        checkLabel(status);
        statusPanel.add(statusLabel);

        globalPanel.add(statusPanel);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        nameLabel= new JLabel("Nome");
        formPanel.add(nameLabel);

        corporateName = new JLabel(name);
        formPanel.add(corporateName);

        ownerLabel = new JLabel("Proprietario");
        formPanel.add(ownerLabel);

        ownerName = new JLabel(owner);
        formPanel.add(ownerName);

        emailLabel = new JLabel("email");
        formPanel.add(emailLabel);

        corporateEmail = new JLabel(mail);
        formPanel.add(corporateEmail);


        globalPanel.add(formPanel);
        //mainFrame.add(formPanel, BorderLayout.NORTH);

        //mainFrame.add(confirmButton, BorderLayout.SOUTH);


        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        this.mainFrame.setVisible(true);


    }

    public void update(int status)
    {
        this.mainFrame.setVisible(false);
        checkLabel(status);
        this.mainFrame.setVisible(true);
    }

    private void checkLabel(int status)
    {
        if(status == 0)
        {
            statusLabel = new JLabel("DA VERIFICARE");
        }
        else if(status == -1)
        {
            statusLabel = new JLabel("RIFIUTATO");
        }
        else
        {
            statusLabel = new JLabel("VERIFICATO");
        }
    }

}
