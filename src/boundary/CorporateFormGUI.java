package boundary;

import control.DatabaseController;
import control.SessionController;
import exceptions.IncompleteFormException;
import exceptions.InvalidMailException;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyRegisteredException;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 26/12/16.
 */
public class CorporateFormGUI implements FormGUI
{
    private SessionController controller = SessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();

    private JFrame mainFrame = new JFrame();

    private JTextField nameField;
    private JTextField ownerField;
    private JTextField emailField;
    private JTextField PIVAField;
    private JPasswordField pwdField;
    private JPasswordField confirmPwdField;
    private JButton confirmButton, cancelButton;
    private JLabel owner;
    private JLabel nome;
    private JLabel PIVA;
    private JLabel email;
    private JLabel pwd;
    private JLabel confirmPwd;

    private JPanel formPanel, globalPanel;


    public CorporateFormGUI(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        globalPanel = new JPanel();
        globalPanel.setLayout(new GridLayout(3,1));

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));

        nome = new JLabel("Nome Azienda");
        formPanel.add(nome);

        nameField = new JTextField();
        formPanel.add(nameField);

        owner = new JLabel("Proprietario");
        formPanel.add(owner);

        ownerField = new JTextField();
        formPanel.add(ownerField);

        email = new JLabel("email");
        formPanel.add(email);

        emailField = new JTextField();
        formPanel.add(emailField);

        PIVA = new JLabel("Partita IVA");
        formPanel.add(PIVA);

        PIVAField = new JTextField();
        formPanel.add(PIVAField);

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


        confirmButton = new JButton("CONFERMA");
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
            if (controller.checkEmptyFields(ownerField.getText()))
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
                        "L'Amministratore verificherà la conformità dei dati", "Confirm",
                        JOptionPane.INFORMATION_MESSAGE);

                //controller.saveData(nameField.getText(), emailField.getText(), ownerField.getText(), pwdField.getPassword());
                //mailController.sendMail(nameField.getText(), emailField.getText());
                this.mainFrame.setVisible(false);
                controller.updateGUI(this.mainFrame, 3);
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
        controller.updateGUI(this.mainFrame, 5);
    }
}
