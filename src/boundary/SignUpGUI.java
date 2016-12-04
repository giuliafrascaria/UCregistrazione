package boundary;

import javax.swing.*;

/**
 * Created by giogge on 03/12/16.
 */
public class SignUpGUI
{
    private JFrame mainFrame;

    private JPanel signupPanel;
    private JButton logInButton;
    private JButton signUpButton;

    public SignUpGUI(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        mainFrame.setTitle("ACCESS");
        mainFrame.setContentPane(signupPanel);

        mainFrame.setVisible(true);
    }
}
