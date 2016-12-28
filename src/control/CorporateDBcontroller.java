package control;

/**
 * Created by giogge on 27/12/16.
 */
public class CorporateDBcontroller extends DatabaseController
{
    private static CorporateDBcontroller ourInstance = new CorporateDBcontroller();
    public static CorporateDBcontroller getOurInstance(){return ourInstance;}
    private CorporateDBcontroller(){}
}
