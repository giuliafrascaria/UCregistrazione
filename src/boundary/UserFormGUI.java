package boundary;

import control.DatabaseController;
import control.MailController;
import control.PrivateSessionController;
import exceptions.IncompleteFormException;
import exceptions.InvalidMailException;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyRegisteredException;

import javax.swing.*;
import java.awt.*;



public class UserFormGUI implements FormGUI
{
    private PrivateSessionController controller = PrivateSessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();
    private MailController mailController = MailController.getInstance();

    private JFrame mainFrame = new JFrame();

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JPasswordField pwdField;
    private JPasswordField confirmPwdField;
    private JButton confirmButton, cancelButton;
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
        globalPanel.setLayout(new GridLayout(3,1));

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

        confirmPwd = new JLabel("Ripeti password");
        formPanel.add(confirmPwd);

        confirmPwdField = new JPasswordField();
        formPanel.add(confirmPwdField);

        globalPanel.add(formPanel);
        //mainFrame.add(formPanel, BorderLayout.NORTH);


        confirmButton = new JButton("SUBMIT");
        confirmButton.addActionListener(actionEvent ->
        {
            submit();
        });


        globalPanel.add(confirmButton);
        //mainFrame.add(confirmButton, BorderLayout.SOUTH);

        cancelButton = new JButton("ANNULLA");
        cancelButton.addActionListener(actionEvent ->
        {
            cancel();
        });
        globalPanel.add(cancelButton);
        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        this.mainFrame.setVisible(true);
    }

    public void submit()
    {
        try{

            if (controller.checkEmptyFields(nameField.getText()))
            {
                throw new IncompleteFormException();
            }
            if (controller.checkEmptyFields(surnameField.getText()))
            {
                throw new IncompleteFormException();
            }
            if (controller.checkEmptyFields(emailField.getText()))
            {
                throw new IncompleteFormException();
            }
            if (!controller.checkValidEmail(emailField.getText()))
            {
                throw new InvalidMailException();
            }
            if (!(controller.checkPWDFields(pwdField.getPassword(), confirmPwdField.getPassword())))
            {
                throw new PasswordMismatchException();
            }

            if (dbController.checkUser(emailField.getText()))
            {
                JOptionPane.showMessageDialog(globalPanel,
                        "Ti verrà inviata una mail di conferma", "Confirm",
                        JOptionPane.INFORMATION_MESSAGE);

                controller.saveData(nameField.getText(), emailField.getText(), surnameField.getText(), pwdField.getPassword());
                mailController.sendMail(nameField.getText(), emailField.getText());
                this.mainFrame.setVisible(false);
                controller.updateGUI(this.mainFrame, 2);
            }
            else
            {
                throw new UserAlreadyRegisteredException();
            }
        }
        catch (PasswordMismatchException e)
        {
            JOptionPane.showMessageDialog(globalPanel, "Password non coincidenti", "ERRORE", JOptionPane.OK_CANCEL_OPTION);
            pwdField.setText(null);
            confirmPwdField.setText(null);
        }
        catch (IncompleteFormException e)
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: compilare tutti i campi", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (InvalidMailException e)
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Errore: inserire una mail valida", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
            emailField.setText(null);
        }
        catch (UserAlreadyRegisteredException e)
        {
            JOptionPane.showMessageDialog(globalPanel,
                    "Un account esiste già per la main indicata", "Error Message",
                    JOptionPane.OK_CANCEL_OPTION);
            emailField.setText(null);
        }
        catch (Exception e) { //manca la messagingException della mail riga 116
            e.printStackTrace();
        }
    }

    public void cancel()
    {
        this.mainFrame.setVisible(false);
        controller.updateGUI(this.mainFrame, 4);
    }

}
