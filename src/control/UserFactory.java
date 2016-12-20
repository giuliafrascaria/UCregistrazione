package control;

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


}
