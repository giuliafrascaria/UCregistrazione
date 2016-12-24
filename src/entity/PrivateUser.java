package entity;


public class PrivateUser extends RegisteredUser
{
    private String email, name, surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
