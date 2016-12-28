package control;

/**
 * Created by giogge on 27/12/16.
 */
public class AdminDBcontroller extends DatabaseController
{
    private static AdminDBcontroller ourInstance = new AdminDBcontroller();
    public static AdminDBcontroller getOurInstance(){return ourInstance;}
    private AdminDBcontroller(){}
}
