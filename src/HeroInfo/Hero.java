package HeroInfo;

import java.util.EnumSet;

public class Hero {
    private String name;
    private String realName;
    public EnumSet<SuperPower> getSuperPowers() {
        return superPowers;
    }
    private EnumSet<SuperPower> superPowers;

    private int yearCreated;
    private boolean isHuman;
    private double strength;

    private String uniquePower;


    public Hero(String name, String realName,EnumSet<SuperPower> superPowers, int yearCreated, boolean isHuman, double strength, String uniquePower)
    {
        this.name = name;
        this.realName = realName;
        this.superPowers = superPowers;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
        this.uniquePower = uniquePower;

    }
    @Override
    public String toString() {
        String heroInfo = "Name: " + name + "\n" +
                "Real Name: " + realName + "\n" +
                "Super Powers: " + superPowers + "\n" +
                "Year Created: " + yearCreated + "\n" +
                "Strength: " + strength + "\n" +
                "Is Human: " + (isHuman ? "Yes" : "No");

        System.out.println("Hero Details: \n" +
                " ");

        return heroInfo;
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

    
    public void setSuperPowers(EnumSet<SuperPower> superPowers) {
        this.superPowers = superPowers;
    }

    public String getUniquePower() {
        return uniquePower;
    }

    public void setUniquePower(String uniquePower) {
        this.uniquePower = uniquePower;
    }


    public int getYearCreated()
    {
        return yearCreated;}
    public void setYearCreated(int yearCreated) {

        this.yearCreated = yearCreated;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public double getStrength() {
        return strength;}

    public void setStrength(double strength) {
        this.strength = strength;
    }
    public enum SuperPower {
        FLIGHT("Ability to fly"),
        TELEPATHY("Ability to read minds"),
        SUPER_STRENGTH("Superhuman strength"),
        INVULNERABILITY("Invulnerability to harm"),
        OCULAR_POWERS("Enhanced vision and laser beams from eyes"),
        TELEKINESIS("Ability to move objects with the mind"),
        SHAPE_SHIFTING("Ability to change physical appearance"),
        TIME_MANIPULATION("Control over time"),
        ELEMENTAL_CONTROL("Control over elements like fire, water, etc."),
        TELEPORTATION("Instantaneous travel from one place to another"),
        SUPER_SPEED("Incredible speed"),
        MIND_CONTROL("Ability to control others' actions through thought"),
        EXCEPTIONAL("A human, so skilled and dedicated that they are regarded as Supers");

        private final String description;

        SuperPower(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public static void displayAllSuperPowers() {
        for (SuperPower power : SuperPower.values()) {
            System.out.println(power.name() + ": " + power.getDescription());

        }

    }
    public static String formatSuperPower(Hero.SuperPower power) {
        String name = power.name().toLowerCase().replace('_', ' ');
        return name.substring(0, 1).toUpperCase() + name.substring(1) + ": "+power.getDescription();
    }




}

