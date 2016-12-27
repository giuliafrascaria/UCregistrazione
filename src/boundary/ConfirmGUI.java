package boundary;

import control.MailController;
import control.SessionController;

import javax.swing.*;
import java.awt.*;

public class ConfirmGUI implements GUI
{

    private SessionController controller = SessionController.getInstance();
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
        confirmPanel.setLayout(new GridLayout(3, 1));

        confirmCode = new JLabel("Inserire codice di conferma");
        confirmPanel.add(confirmCode);

        confirmText = new JTextField();
        confirmPanel.add(confirmText);

        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(ActionEvent ->
        {
            if (controller.checkEmptyFields(confirmText.getText()))
            {
                JOptionPane.showMessageDialog(confirmPanel,
                        "Errore: inserire il nome", "Error Massage",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(mailController.checkHash(confirmText.getText()))
                {
                    JOptionPane.showMessageDialog(confirmPanel,
                            "Registrazione completata", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    try
                    {
                        //controller.addUser();
                        this.mainFrame.setVisible(false);
                        controller.updateGUI(this.mainFrame, 3);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        confirmPanel.add(submitButton);

        this.mainFrame = mainFrame;

        this.mainFrame.add(confirmPanel);

        this.mainFrame.setTitle("CONFIRM");
        this.mainFrame.setContentPane(confirmPanel);

        this.mainFrame.setVisible(true);
    }

}
