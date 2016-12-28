package control;


public class PrivateDBcontroller extends DatabaseController
{
    private static PrivateDBcontroller ourInstance = new PrivateDBcontroller();
    public static PrivateDBcontroller getOurInstance(){return ourInstance;}
    private PrivateDBcontroller(){}
}
