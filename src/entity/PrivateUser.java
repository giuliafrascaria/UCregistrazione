package entity;


public class PrivateUser
{
    private String email, name;
    private char[] pwd;

    public PrivateUser() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public char[] getPwd()
    {
        return pwd;
    }

    public void setPwd(char[] pwd)
    {
        this.pwd = pwd;
    }


}
