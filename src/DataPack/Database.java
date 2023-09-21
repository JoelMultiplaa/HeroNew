package DataPack;
import HeroInfo.Hero;
import InputPack.InputHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class Database {

    private final ArrayList<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public ArrayList<Hero> heroesList() {
        return heroes;
    }

    public Hero findHero(String searchName) {
        for (Hero h : heroes) {
            if (h.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Hero found in the Registry:");
                System.out.println();
                System.out.println(h.toString());
                return h;
            }
        }
        System.out.println("Hero not found in the Registry");
        return null;
    }
    public void updateHero(String name, String newName, String newRealName, String newSuperPower, int newYearCreated, boolean newIsHuman, double newStrength) {
        for (Hero hero : heroes) {
            if (hero.getName().equalsIgnoreCase(name)) {
                hero.setName(newName);
                hero.setRealName(newRealName);
                hero.setSuperPower(newSuperPower);
                hero.setYearCreated(newYearCreated);
                hero.setIsHuman(newIsHuman);
                hero.setStrength(newStrength);
                return;
            }
        }
        System.out.println("Hero not found for update.");
    }
    public ArrayList<Hero> findHeroesByPartOfName(String searchPart) {
        ArrayList<Hero> matchingHeroes = new ArrayList<>();
        for (Hero h : heroes) {
            if (h.getName().toLowerCase().contains(searchPart.toLowerCase())) {
                matchingHeroes.add(h);
            }
        }
        return matchingHeroes;
    }

    public boolean deleteHero(String name, int choice) {
        Iterator<Hero> iterator = heroes.iterator();
        boolean heroFound = false;

        while (iterator.hasNext()) {
            Hero hero = iterator.next();
            if (hero.getName().equalsIgnoreCase(name)) {
                heroFound = true;
                if (choice == 1) {
                    iterator.remove(); // Remove the hero from the list
                }
                break; // Exit the loop when the hero is found
            }
        }

        if (!heroFound) {
            System.out.println();
        } else if (choice == 2) {
            System.out.println();
        }

        return heroFound && choice == 1;
    }

    public boolean deleteHero(String name) {


        return false;
    }
}
