import boundary.AccessGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giogge on 03/12/16.
 */
public class Main
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                SizedFrame mainFrame = new SizedFrame();

                //SignUpGUI gui = new SignUpGUI(mainFrame);

                AccessGUI gui = new AccessGUI(mainFrame);
            }
        });
    }
}

class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int getScreenWidth = screenSize.width;

        setSize(getScreenWidth/2, screenHeight/2);
        setLocationByPlatform(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
