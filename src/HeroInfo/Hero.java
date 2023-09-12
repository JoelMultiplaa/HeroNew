package HeroInfo;

public class Hero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private boolean isHuman;
    private double strength;

    public Hero(String name, String realName, String superPower, int yearCreated, boolean isHuman, double strength)
    {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getRealName()
    {
        return realName;
    }
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getSuperPower()
    {
        return superPower;}
    public void setSuperPower(String superPower)
    {
        this.superPower = superPower;
    }

    public int getYearCreated()
    {
        return yearCreated;}
    public void setYearCreated(int yearCreated) {

        this.yearCreated = yearCreated;
    }

    public boolean isHuman() {
        if (isHuman)
            return isHuman;
        return false;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public double getStrength() {
        return strength;}

    public void setStrength(double strength) {
        this.strength = strength;
    }
}

