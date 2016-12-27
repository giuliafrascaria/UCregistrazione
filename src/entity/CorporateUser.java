package entity;


public class CorporateUser extends RegisteredUser
{
    private String email, name, owner, piva;
    private char[] pwd;

    public CorporateUser() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
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
