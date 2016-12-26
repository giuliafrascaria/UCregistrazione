package control;

import entity.Admin;
import entity.CorporateUser;
import entity.PrivateUser;


class UserFactory
{

    private static UserFactory ourInstance = new UserFactory();
    static UserFactory getInstance() {
        return ourInstance;
    }

    private UserFactory() {}

    PrivateUser createUser()
    {
        return new PrivateUser();
    }

    CorporateUser createCorporateUser() {return new CorporateUser();}

    Admin createAdmin() {return new Admin();}


}
