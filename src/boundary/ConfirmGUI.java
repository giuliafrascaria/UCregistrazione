package boundary;

import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;

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
        //signupPanel.setLayout(new GridLayout(5, 4));

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

        mainFrame.setVisible(true);
    }
}
