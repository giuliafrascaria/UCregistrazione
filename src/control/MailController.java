package control;
import java.util.*;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Created by giogge on 05/12/16.
 */
public class MailController
{

    private static MailController ourInstance = new MailController();

    public static MailController getInstance() {
        return ourInstance;
    }

    private MailController()
    {

    }

    public boolean checkHash(String userInput)
    {
        return true;
    }

    private int hashGenerator(String name, String mail)
    {
        return Objects.hash(name, mail);
    }

    public void sendMail(String name, String mail) throws MessagingException
    {

        int hashcode = this.hashGenerator(name, mail);
        System.out.println(hashcode);

        //---------------------------------------------------------------
        /*Properties props = new Properties();
        props.put("mail.smtp.host", "mail.domain.com");

        props.put("mail.smtp.auth","false");
        props.put("mail.smtp.starttls.enable","false");
        props.put("mail.smtp.port","25");

        Session session = Session.getDefaultInstance(props);

        Transport transport = session.getTransport("smtp");
        transport.connect();
*//*        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;*//*

        try
        {



            Message message = new MimeMessage(session);

            *//*fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);*//*

            message.setFrom(new InternetAddress("DaDa" + "<" + "no-reply@domain.com" + ">"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            String subject = "Codice di conferma";
            message.setSubject(subject);
            String content = "Ciao " + name + "! il tuo codice di conferma è " + hashcode;
            message.setContent(content, "text/html; charset=UTF-8");

            //transport.sendMessage(message, message.getAllRecipients());
            System.out.println("mail mandata");
            //return true;
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
        finally
        {
            transport.close();
        }
    }*/

    }
}