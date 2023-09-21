package UiPack;

import InputPack.InputHelper;
import ControlPack.Controller;
import DataPack.Database;
import HeroInfo.Hero;
import java.util.ArrayList;
import java.util.Scanner;


public class HeroUI {
    private final Controller controller;
    public HeroUI(Controller controller) {
        this.controller = controller;
    }
    public void startProgram() {

        Database db = new Database();
        Controller controller = new Controller(db);
        Scanner keyboard = new Scanner(System.in);
        InputHelper inputHelper = new InputHelper(keyboard);

        db.addHero(new Hero("Superman", "Clark Kent", "Flight, Super strength", 1938, false, 100));
        db.addHero(new Hero("Batman", "Bruce Wayne", "Intelligence, Martial Arts", 1939, true, 70));

        System.out.println("Welcome to Hero World! ");
        System.out.println(); // Line break for readability
        int userChoice;
        do {
            System.out.println("""
                     1. Create New Hero
                     2. See Hero Registry
                     3. Search Hero Registry
                     4. Edit A Hero
                     5. Delete A Hero
                     6. Leave Hero World.
                    """);
            userChoice = inputHelper.promptInt("Enter your choice (1-6):");


            switch (userChoice) {
                case 1 -> {
                    System.out.println("Let's Create A New Hero, Press Enter To Continue!");
                    keyboard.nextLine(); // Line Consumed for readability
                    System.out.println(); // Line break for readability
                    String name = inputHelper.promptString("Input Hero Moniker: ");
                    String realName = inputHelper.promptString("Input Real Name: ");
                    String superPowers = inputHelper.promptString("Input Super Powers: ");
                    int yearCreated = inputHelper.promptInt("Input Year Created: ");
                    double strength = inputHelper.promptDouble("Input Strength Number: ");
                    boolean isHuman = inputHelper.promptBoolean("Is the Hero Human, y/n?");

                    Hero newHero = new Hero(name, realName, superPowers, yearCreated, isHuman, strength);
                    db.addHero(newHero);
                    System.out.println("Thank You. Your Hero Has Been Registered ");
                    System.out.println(); // Line break for readability
                    System.out.println(newHero.toString());
                    System.out.println(); // Line break for readability


                }
                case 2 -> {
                    System.out.println("Our Registered Heroes: ");
                    System.out.println();
                    ArrayList<Hero> heroesList = controller.getHeroesList();
                    for (Hero hero : heroesList) {
                        System.out.println(hero.toString());
                        System.out.println(); // Line break for readability
                    }
                }
                case 3 -> {
                    System.out.println("Please Input Hero Name ");
                    String searchPart = inputHelper.promptString("");
                    System.out.println(); // Line break for readability
                    ArrayList<Hero> matchingHeroes = db.findHeroesByPartOfName(searchPart);
                    if (!matchingHeroes.isEmpty()) {
                        System.out.println("Matching Heroes:");
                        for (int i = 0; i < matchingHeroes.size(); i++) {
                            Hero hero = matchingHeroes.get(i);
                            System.out.println((i + 1) + ". " + hero.getName());
                        }
                        System.out.println("Select a hero (enter the number): ");
                        int selection = inputHelper.promptInt("");

                        if (selection >= 1 && selection <= matchingHeroes.size()) {
                            Hero selectedHero = matchingHeroes.get(selection - 1);

                            System.out.println(selectedHero.toString());
                            System.out.println(); // Line break for readability

                            System.out.println("Press Enter to Continue...");
                            keyboard.nextLine();
                            System.out.println(); // Line break for readability
                        } else {
                            System.out.println("Invalid selection.");
                        }

                    } else {
                        System.out.println("Click Enter to Continue");
                        keyboard.nextLine(); // Break to consume line
                        System.out.println(); // Line break for readability
                        keyboard.nextLine();
                    }
                }
                case 4 -> {
                    System.out.println("Please Input Hero Name to Edit: ");
                    String heroNameToEdit = inputHelper.promptString("");

                    Hero heroToEdit = db.findHero(heroNameToEdit);

                    if (heroToEdit != null) {
                        System.out.println(); // Line break for readability
                        String newName = inputHelper.promptString("Enter new Hero Moniker: ");
                        System.out.println();
                        String newRealName = inputHelper.promptString("Enter new Real Name: ");
                        System.out.println();
                        String newSuperPowers = inputHelper.promptString("Enter new Super Powers: ");
                        System.out.println();
                        int newYearCreated = inputHelper.promptInt("Enter new Year Created: ");
                        System.out.println();
                        double newStrength = inputHelper.promptDouble("Enter new Strength Number: ");
                        System.out.println();
                        boolean newIsHuman = inputHelper.promptBoolean("Is the Hero Human? Input y/n: ");

                        // Update the Hero's attributes
                        db.updateHero(heroNameToEdit, newName, newRealName, newSuperPowers, newYearCreated, newIsHuman, newStrength);
                        heroToEdit.setName(newName);

                        Hero updatedHero = db.findHero(newName); // Displaying the updated Hero's details, note that updatedHero, is only named so for readability.
                        System.out.println("Your Hero Has Been Updated,");
                        System.out.println(); // Line break for readability
                    } else {
                        System.out.println();
                    }
                }
                case 5 -> {
                    String heroNameToDelete = inputHelper.promptString("Enter the Hero Name to Delete:");
                    int choice = inputHelper.promptInt("Are you sure you want to delete " + heroNameToDelete + "? (1 for Yes, 2 for No)");
                    boolean deleted = db.deleteHero(heroNameToDelete, choice);
                    if (deleted) {
                        System.out.println("Hero deleted successfully.");
                        System.out.println(); // Line break for readability
                    } else {
                        System.out.println(choice == 2 ? "Deletion canceled." : "Hero not found for deletion.");
                        System.out.println(); // Line break for readability
                    }
                }
                case 6 -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            }
        } while (true);
    }

}