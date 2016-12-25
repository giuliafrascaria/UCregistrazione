package boundary;

import control.SessionController;

import javax.swing.*;
import java.awt.*;


public class AccessGUI implements GUI
{

    private SessionController controller = SessionController.getInstance();
    private JFrame mainFrame;

    private JPanel signupPanel;
    private JButton corporateSignUpButton;
    private JButton privateSignUpButton;

    public AccessGUI(JFrame mainFrame)
    {

        signupPanel = new JPanel();
        //signupPanel.setLayout(new GridLayout(5, 4));

        corporateSignUpButton = new JButton("SIGN UP AZIENDA");
        privateSignUpButton = new JButton("SIGN UP PRIVATO");

        signupPanel.add(corporateSignUpButton);
        signupPanel.add(privateSignUpButton);

        this.mainFrame = mainFrame;

        this.mainFrame.add(signupPanel);

        this.mainFrame.setTitle("ACCESS");
        this.mainFrame.setContentPane(signupPanel);

        this.privateSignUpButton.addActionListener(actionEvent ->
        {
            this.mainFrame.setVisible(false);
            controller.updateGUI(this.mainFrame, 1);
        });

        this.corporateSignUpButton.addActionListener(actionEvent ->
        {
            this.mainFrame.setVisible(false);
            controller.updateGUI(this.mainFrame, 1);
        });

        mainFrame.setVisible(true);
    }
}
