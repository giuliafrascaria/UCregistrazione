package boundary;

import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;


public class AdminGUI extends Observable implements GUI
{
    private SessionController controller = SessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();
    private MailController mailController = MailController.getInstance();

    private JFrame mainFrame = new JFrame();

    private JButton confirmButton;
    private JButton rejectButton;
    private JLabel corporateName;
    private JLabel OwnerName;
    private JLabel email;

    private JLabel P_IVA;

    private JPanel formPanel, globalPanel, examinPanel;

    public AdminGUI(JFrame mainFrame, String name, String surname, String mail)
    {

        this.mainFrame = mainFrame;

        globalPanel = new JPanel();
        globalPanel.setLayout(new GridLayout(2,1));

        examinPanel = new JPanel();


        globalPanel.add(examinPanel);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        email = new JLabel("email");
        formPanel.add(email);

        globalPanel.add(formPanel);
        //mainFrame.add(formPanel, BorderLayout.NORTH);

        //mainFrame.add(confirmButton, BorderLayout.SOUTH);


        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        this.mainFrame.setVisible(true);


    }
}
