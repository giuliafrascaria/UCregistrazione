package boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        signUpButton.addActionListener(actionEvent -> {
            this.mainFrame.setVisible(false);
            //passa per controller
            FormGUI gui = new FormGUI(this.mainFrame);
        });

        mainFrame.setVisible(true);
    }
}


