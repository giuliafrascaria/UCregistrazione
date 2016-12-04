package boundary;

import javax.swing.*;

/**
 * Created by giogge on 03/12/16.
 */
public class FormGUI
{
    private JFrame mainFrame = new JFrame();

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JPasswordField pwdField;
    private JPasswordField confirmPwdField;
    private JButton SIGNUPButton;
    private JLabel cognome;
    private JLabel nome;
    private JLabel pwd;
    private JLabel confirmPwd;
    private JPanel FORMpanel;
    private JPanel FIELDpanel;

    public FormGUI()
    {


        mainFrame.setContentPane(FIELDpanel);
        mainFrame.pack();


        mainFrame.setVisible(true);
    }
}
