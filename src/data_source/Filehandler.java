package data_source;

import domain_model.Hero;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Filehandler {


    public static final String DELIMITER = ",";

    public static void saveToCsvFile(List<Hero> heroes) {

        File file = new File("HeroFile.txt");
        try {
            PrintStream output = new PrintStream(file);
            for (Hero hero : heroes) {
                output.println(hero.getName() + DELIMITER + hero.getRealName() + DELIMITER + hero.getSuperPowers().toString() +
                        DELIMITER + hero.getYearCreated() + DELIMITER + hero.isHuman() + DELIMITER + hero.getStrength() + DELIMITER +
                        hero.getUniquePower());
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Hero> loadFromCsvFile() {
        File file = new File("HeroFile.txt");
        ArrayList<Hero> heroes = new ArrayList<>();

        if (!Files.exists(file.toPath())) {
            return heroes;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(DELIMITER);
                if (values.length >= 7) {
                    String name = values[0];
                    String realName = values[1];
                    EnumSet<Hero.SuperPower> superPowers = EnumSet.noneOf(Hero.SuperPower.class);
                    //String[] powers = values[2].replace("[", "").replace("]", "").split("\\s*,\\s*");
                    String[] powers = values[2].trim().split("-");
                    for (String power : powers) {
                        superPowers.add(Hero.SuperPower.valueOf(power));
                    }
                    int yearCreated = Integer.parseInt(values[3].trim());
                    boolean isHuman = Boolean.parseBoolean(values[4].trim());
                    double strength = Double.parseDouble(values[5].trim());
                    String uniquePower = values[6];

                    Hero hero = new Hero(name, realName, superPowers, yearCreated, isHuman, strength, uniquePower);
                    heroes.add(hero);

                } else {
                    System.out.println("Error");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return heroes;
    }
}