package data_source;
import domainmodel.Hero;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


public class FileHandler {

    public final String DELIMITER = ",";

    public void saveToFile(ArrayList<Hero> heroes) {
        File file = new File("HeroNew.txt");

        try {
            PrintStream output = new PrintStream(file);
            for (Hero hero : heroes) {
                output.println(hero.getName() + DELIMITER + hero.getRealName() + DELIMITER + hero.getSuperPower() + DELIMITER + hero.isHuman() + DELIMITER + hero.getStrength() + DELIMITER + hero.getYearCreated());
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


      public void loadFromFile(ArrayList<Hero> heroes) {
        File file = new File("HeroNew.txt");

          try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] attributes = line.split(DELIMITER);

                Hero loadedHero = new Hero(attributes[0], attributes[1], attributes[2], Integer.parseInt(attributes[3]), Boolean.parseBoolean(attributes[4]), Integer.parseInt(attributes[5]));
                heroes.add(loadedHero);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


