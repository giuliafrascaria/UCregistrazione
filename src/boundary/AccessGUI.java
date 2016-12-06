package boundary;

import control.SessionController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 05/12/16.
 */
public class AccessGUI implements GUI
{

    private SessionController controller = SessionController.getInstance();
    private JFrame mainFrame;

    private JPanel signupPanel;
    private JButton logInButton;
    private JButton signUpButton;

    public AccessGUI(JFrame mainFrame)
    {

        signupPanel = new JPanel();
        //signupPanel.setLayout(new GridLayout(5, 4));

        logInButton = new JButton("LOG IN");
        signUpButton = new JButton("SIGN UP");

        signupPanel.add(logInButton);
        signupPanel.add(signUpButton);

        this.mainFrame = mainFrame;

        this.mainFrame.add(signupPanel);

        this.mainFrame.setTitle("ACCESS");
        this.mainFrame.setContentPane(signupPanel);

        this.signUpButton.addActionListener(actionEvent ->
        {
            this.mainFrame.setVisible(false);
            controller.updateGUI(this.mainFrame, 1);
        });

        mainFrame.setVisible(true);
    }
}
