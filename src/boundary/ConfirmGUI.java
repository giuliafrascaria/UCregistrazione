package boundary;

import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 05/12/16.
 */
public class ConfirmGUI implements GUI
{

    private SessionController controller = SessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();
    private MailController mailController = MailController.getInstance();

    private JFrame mainFrame = new JFrame();

    private JPanel confirmPanel;
    private JButton submitButton;
    private JTextField confirmText;
    private JLabel confirmCode;

    public ConfirmGUI(JFrame mainFrame)
    {

        this.mainFrame = mainFrame;
        confirmPanel = new JPanel();
        confirmPanel.setLayout(new GridLayout(3, 1));

        confirmCode = new JLabel("Inserire codice di conferma");
        confirmPanel.add(confirmCode);

        confirmText = new JTextField();
        confirmPanel.add(confirmText);

        submitButton = new JButton("SUBMIT");

        confirmPanel.add(submitButton);

        this.mainFrame = mainFrame;

        this.mainFrame.add(confirmPanel);

        this.mainFrame.setTitle("CONFIRM");
        this.mainFrame.setContentPane(confirmPanel);

        this.mainFrame.setVisible(true);
    }

    private void checkHash()
    {
        if(mailController.checkHash(confirmText.getText()))
        {
            //chiama dbController per inserire nel db
        }
    }
}
