package domain_model;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

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
    public static List<Hero> searchHeroesByPowers(List<Hero> heroesList, EnumSet<Hero.SuperPower> searchPowers) {
        return heroesList.stream()
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
        return db.heroesList();
    }
}
