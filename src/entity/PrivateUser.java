package entity;

/**
 * Created by giogge on 03/12/16.
 */
public class PrivateUser
{
    private String name, email;

    public PrivateUser(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
