package domain_model;
import data_source.Filehandler;
import userinterface.HeroUI;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final Database db;

    public Controller() {

        this.db = new Database();
    }
    public ArrayList<Hero> findHeroesByPartOfName(String searchPart) {
        ArrayList<Hero> matchingHeroes = new ArrayList<>();
        for (Hero h : db.getHeroes()) {
            if (h.getName().toLowerCase().contains(searchPart.toLowerCase())) {
                matchingHeroes.add(h);
            }
        }
        return matchingHeroes;
    }
    public static List<Hero> searchHeroesByPowers(List<Hero> heroes, EnumSet<Hero.SuperPower> searchPowers) {
        return heroes.stream()
                .filter(hero -> hero.getSuperPowers().containsAll(searchPowers))
                .collect(Collectors.toList());
    }
    public Hero findHero(String foundHeroName) {
        return db.findHero(foundHeroName);
    }
    public void addHero(Hero hero) {
        db.addHero(hero);
}
    public void updateHero(String name, String newName, String newRealName, EnumSet<Hero.SuperPower> newSuperPowers, int newYearCreated, boolean newIsHuman, double newStrength, String newUniquePower) {
        db.updateHero(name, newName, newRealName, newSuperPowers, newYearCreated, newIsHuman, newStrength, newUniquePower);
    }
    public ArrayList<Hero> getHeroesList() {
        return db.getHeroes();
    }
    public void startProgram() {
        Filehandler filehandler = new Filehandler();
        ArrayList<Hero> heroes = filehandler.loadFromCsvFile();
        db.setHeroesList(heroes);
        HeroUI heroUI = new HeroUI(this);
        heroUI.startProgram(db);
    }
}
