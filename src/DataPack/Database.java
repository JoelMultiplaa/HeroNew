package DataPack;
import HeroInfo.Hero;
import java.util.ArrayList;
public class Database {

    private final ArrayList<Hero> heroes = new ArrayList<>();


    public void addHero(Hero hero){

        heroes.add(hero);
    }
    public ArrayList<Hero> heroesList() {

        return heroes;
    }
    public ArrayList<Hero> findHero;


    public Hero findHero(String searchName) {
        for (Hero h : heroes) {
            if (h.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Hero found in the Registry:");
                System.out.println();
                toString();
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

//    public void deleteHero(String name) {
//        Iterator<Hero> iterator = heroes.iterator();
//        while (iterator.hasNext()) {
//            Hero hero = iterator.next();
//            if (hero.getName().equalsIgnoreCase(name)) {
//                iterator.remove(); // Remove the hero from the list
//                System.out.println("Hero deleted successfully.");
//                return; // Exit the loop after deleting
//            }
//        }
//        System.out.println("Hero not found for deletion.");
//    }
}
