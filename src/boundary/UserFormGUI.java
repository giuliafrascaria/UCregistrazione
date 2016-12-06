package boundary;

import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 05/12/16.
 */
public class UserFormGUI implements GUI
{
    SessionController controller = SessionController.getInstance();
    DatabaseController dbController = DatabaseController.getInstance();
    MailController mailController = MailController.getInstance();

    private JFrame mainFrame = new JFrame();

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JPasswordField pwdField;
    private JPasswordField confirmPwdField;
    private JButton confirmButton;
    private JLabel cognome;
    private JLabel nome;
    private JLabel email;
    private JLabel pwd;
    private JLabel confirmPwd;

    private JPanel formPanel, globalPanel;


    public UserFormGUI(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        globalPanel = new JPanel();
        globalPanel.setLayout(new GridLayout(2,1));

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));

        nome = new JLabel("Nome");
        formPanel.add(nome);

        nameField = new JTextField();
        formPanel.add(nameField);

        cognome = new JLabel("Cognome");
        formPanel.add(cognome);

        surnameField = new JTextField();
        formPanel.add(surnameField);

        email = new JLabel("email");
        formPanel.add(email);

        emailField = new JTextField();
        formPanel.add(emailField);

        pwd = new JLabel("Password");
        formPanel.add(pwd);

        pwdField = new JPasswordField();
        formPanel.add(pwdField);

        confirmPwd = new JLabel("Confirm password");
        formPanel.add(confirmPwd);

        confirmPwdField = new JPasswordField();
        formPanel.add(confirmPwdField);

        globalPanel.add(formPanel);
        //mainFrame.add(formPanel, BorderLayout.NORTH);


        confirmButton = new JButton("CONFIRM");
        confirmButton.addActionListener(actionEvent ->
        {
            if(controller.checkFields(this.formPanel))
            {
                if(dbController.checkUser())
                {
                    mailController.sendMail();
                }
                else
                {

                }
            }
            else
            {

            }
        });
        globalPanel.add(confirmButton);
        //mainFrame.add(confirmButton, BorderLayout.SOUTH);


        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        mainFrame.setVisible(true);
    }
}
