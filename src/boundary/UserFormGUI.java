package boundary;

import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by giogge on 05/12/16.
 */
public class UserFormGUI implements GUI
{
    private SessionController controller = SessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();
    private MailController mailController = MailController.getInstance();

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
            if(!checkFields())
            {
                if(dbController.checkUser(emailField.getText()))
                {
                    JOptionPane.showMessageDialog(globalPanel,
                            "Ti verrà inviata una mail di conferma", "Confirm",
                            JOptionPane.INFORMATION_MESSAGE);
                    mailController.sendMail(emailField.getText());
                    //this.mainFrame.setVisible(false);
                    //controller.updateGUI(this.mainFrame, 2);
                }
            }
        });
        globalPanel.add(confirmButton);
        //mainFrame.add(confirmButton, BorderLayout.SOUTH);


        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        this.mainFrame.setVisible(true);
    }

    private boolean checkFields()
    {
        if (controller.checkEmptyFields(nameField.getText()))
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: inserire il nome", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        }
        if (controller.checkEmptyFields(surnameField.getText()))
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: inserire il cognome", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        }
        if (controller.checkEmptyFields(emailField.getText()))
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: inserire una mail", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        }
        if (!controller.checkValidEmail(emailField.getText()))
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: inserire una mail valida", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
            emailField.setText(null);
            return false;

        }
        if (!controller.checkPWDFields(pwdField.getPassword(), confirmPwdField.getPassword()))
        {
            JOptionPane.showMessageDialog(globalPanel, "Password non coincidenti", "ERRORE", JOptionPane.OK_CANCEL_OPTION);
            pwdField.setText(null);
            confirmPwdField.setText(null);
            return false;

        }


        return true;
    }


}
