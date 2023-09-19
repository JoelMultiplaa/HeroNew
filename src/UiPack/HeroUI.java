package UiPack;

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

        db.addHero(new Hero("Superman", "Clark Kent", "Flight, Super strength", 1938, false, 100));
        db.addHero(new Hero("Batman", "Bruce Wayne", "Intelligence, Martial Arts", 1939, true, 70));

        System.out.println("Welcome to the Hero Registry! ");
        int userChoice;
        do {
            System.out.println("""
                     1. Create New Hero
                     2. See Hero Registry
                     3. Search Hero Registry
                     4. Edit A Hero
                     5. Leave Hero World.
                    """);
            userChoice = keyboard.nextInt();

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Let's Create A New Hero, Press Enter To Continue!");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    System.out.println("Input Hero Moniker ");
                    String name = keyboard.nextLine();
                    System.out.println("Input Real Name ");
                    String realName = keyboard.nextLine();
                    System.out.println("Input Super Powers ");
                    String superPowers = keyboard.nextLine();
                    System.out.println("Input Year Created ");
                    int yearCreated = keyboard.nextInt();
                    System.out.println("Input Strength Number ");
                    double strength = keyboard.nextDouble();
                    System.out.println("Are They Human? Input y/n");
                    if (keyboard.next().equalsIgnoreCase("Y")) {
                        boolean isHuman = true;
                        System.out.println("Thank You. Your Hero Has Been Registered ");

                        Hero newHero = new Hero(name, realName, superPowers, yearCreated, isHuman, strength);

                        controller.addHero(newHero);

                        System.out.printf(newHero.toString());




                    }
                }
                case 2 -> {
                    System.out.println("Our Registered Heroes: ");
                    System.out.println();
                    ArrayList<Hero> heroesList = controller.getHeroesList();
                    for (Hero hero : heroesList) {
                        System.out.println(hero.toString()); // Calling toString() on the Hero object
                        System.out.println(); // Add a line break for readability
                    }
                }
                case 3 -> {
                    System.out.println("Please Input Hero Name ");
                    String searchPart = keyboard.nextLine();
                    keyboard.nextLine();
                    ArrayList<Hero> matchingHeroes = db.findHeroesByPartOfName(searchPart);
                    if (!matchingHeroes.isEmpty()) {
                        System.out.println("Matching Heroes:");
                        for (int i = 0; i < matchingHeroes.size(); i++) {
                            Hero hero = matchingHeroes.get(i);
                            System.out.println((i + 1) + ". " + hero.getName());
                        }
                        System.out.println("Select a hero (enter the number): ");
                        int selection = keyboard.nextInt();

                        if (selection >= 1 && selection <= matchingHeroes.size()) {
                            Hero selectedHero = matchingHeroes.get(selection - 1);

                            System.out.println(selectedHero.toString()); // Calling toString() on the Hero object
                            System.out.println(); // Add a line break for readability

                            System.out.println("Press Enter to Continue...");
                            keyboard.nextLine();
                            System.out.println();
                            keyboard.nextLine();
                        } else {
                            System.out.println("Invalid selection.");
                        }

                    } else {
                        System.out.println("Click Enter to Continue");
                        keyboard.nextLine();
                        System.out.println();
                        keyboard.nextLine();

                    }
                }
                case 4 -> {
                    System.out.println("Please Input Hero Name to Edit: ");
                    keyboard.nextLine();
                    String heroNameToEdit = keyboard.nextLine();
                    System.out.println();
                    Hero heroToEdit = db.findHero(heroNameToEdit);
                    if (heroToEdit != null) {
                        System.out.println("Hero found. Editing Hero: " + heroToEdit.toString());
                        System.out.println("Enter new Hero Moniker: ");
                        String newName = keyboard.nextLine();
                        System.out.println("Enter new Real Name: ");
                        String newRealName = keyboard.nextLine();
                        System.out.println("Enter new Super Powers: ");
                        String newSuperPowers = keyboard.nextLine();
                        System.out.println("Enter new Year Created: ");
                        int newYearCreated = 0;
                        while (true) {
                            try {
                                newYearCreated = Integer.parseInt(keyboard.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }
                        }
                        double newStrength = 0.0;
                        while (true) {
                            try {
                                System.out.println("Enter new Strength Number: ");
                                newStrength = Double.parseDouble(keyboard.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }
                        }

                        System.out.println("Is the Hero Human? Input y/n: ");
                        boolean newIsHuman = keyboard.next().equalsIgnoreCase("Y");

                        // Update the Hero's attributes
                        db.updateHero(heroNameToEdit, newName, newRealName, newSuperPowers, newYearCreated, newIsHuman, newStrength);
                        heroToEdit.setName(newName);
                        // Display the updated Hero's details
                        Hero updatedHero = db.findHero(newName);
                        System.out.println("Your Hero Has Been Updated, Click Enter To View It!");
                        keyboard.nextLine();
                        System.out.println();
                        keyboard.nextLine();
                        System.out.println(updatedHero.toString()); // Calling toString() on the Hero object
                        System.out.println(); // Add a line break for readability
                    } else {
                        System.out.println();
                    }

                }
                case 5 -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            }

        } while (true);


    }

}