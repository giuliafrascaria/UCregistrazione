package boundary;


import control.DatabaseController;
import control.MailController;
import control.SessionController;

import javax.swing.*;
import java.awt.*;

public class ProfileGUI implements GUI
{

    private SessionController controller = SessionController.getInstance();
    private DatabaseController dbController = DatabaseController.getInstance();
    private MailController mailController = MailController.getInstance();

    private JFrame mainFrame = new JFrame();



    private JButton confirmButton;
    private JLabel cognome;
    private JLabel nome;
    private JLabel email;
    private JLabel welcome;

    private JLabel cognomeUtente;
    private JLabel nomeUtente;
    private JLabel emailUtente;

    private JPanel formPanel, globalPanel, welcomePanel;

    public ProfileGUI(JFrame mainFrame, String name, String surname, String mail)
    {

        this.mainFrame = mainFrame;

        globalPanel = new JPanel();
        globalPanel.setLayout(new GridLayout(2,1));

        welcomePanel = new JPanel();

        welcome = new JLabel("\n\nBENVENUTO IN DaDa!!!");
        welcomePanel.add(welcome);

        globalPanel.add(welcomePanel);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        nome = new JLabel("Nome");
        formPanel.add(nome);

        nomeUtente = new JLabel(name);
        formPanel.add(nomeUtente);

        cognome = new JLabel("Cognome");
        formPanel.add(cognome);

        cognomeUtente = new JLabel(surname);
        formPanel.add(cognomeUtente);

        email = new JLabel("email");
        formPanel.add(email);

        emailUtente = new JLabel(mail);
        formPanel.add(emailUtente);


        globalPanel.add(formPanel);
        //mainFrame.add(formPanel, BorderLayout.NORTH);

        //mainFrame.add(confirmButton, BorderLayout.SOUTH);


        this.mainFrame.setContentPane(globalPanel);
        //mainFrame.pack();


        this.mainFrame.setVisible(true);


    }
}

