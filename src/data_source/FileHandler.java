package data_source;
import domainmodel.Hero;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileHandler {
    public static void saveToFile(ArrayList<Hero> heroes) {
        File file = new File("HeroNew.txt");

        try {
            PrintStream output = new PrintStream(file);
            for(Hero hero : heroes) {
                output.println(hero.getName() + "," + hero.getRealName() + "," + hero.getSuperPower() + "," + hero.isHuman() + "," + hero.getStrength() + "," + hero.getYearCreated() );
            }
            output.println("File has been saved");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
