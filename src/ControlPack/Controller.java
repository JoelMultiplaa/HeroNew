package ControlPack;
import DataPack.Database;
import HeroInfo.Hero;
import java.util.ArrayList;

public class Controller {

    private final Database db;

    public Controller(Database db) {
        this.db = db;
    }
    public ArrayList<Hero> findHeroesByPartOfName(String searchPart) {
        ArrayList<Hero> matchingHeroes = new ArrayList<>();
        for (Hero h : db.heroesList()) {
            if (h.getName().toLowerCase().contains(searchPart.toLowerCase())) {
                matchingHeroes.add(h);
            }
        }
        return matchingHeroes;
    }
    public Hero findHero(String foundHeroName) {
        return db.findHero(foundHeroName);
    }
    public void addHero(Hero hero) {
        db.addHero(hero);
}
    public void updateHero(String name, String newName, String newRealName, String newSuperPower, int newYearCreated, boolean newIsHuman, double newStrength) {
        db.updateHero(name, newName, newRealName, newSuperPower, newYearCreated, newIsHuman, newStrength);
    }


    public ArrayList<Hero> getHeroesList() {
        return db.heroesList();
    }
}
