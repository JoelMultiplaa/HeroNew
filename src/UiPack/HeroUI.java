package UiPack;

import InputPack.InputHelper;
import ControlPack.Controller;
import DataPack.*;
import HeroInfo.Hero;

import java.io.IOException;
import java.util.*;



public class HeroUI {
    private final Controller controller;
    private Filehandler filehandler;

    public HeroUI(Controller controller) {
        this.controller = controller;
    }
    public void startProgram() {

        Database db = new Database();
        Controller controller = new Controller(db);
        this.filehandler = new Filehandler();
        Scanner keyboard = new Scanner(System.in);
        InputHelper inputHelper = new InputHelper(keyboard);
        

//       db.addHero(new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100.0, "Solar Energy Absorption"));
//        db.addHero(new Hero("Batman", "Bruce Wayne", EnumSet.of(Hero.SuperPower.EXCEPTIONAL), 1939, true, 70, "Genius-level intellect"));

        System.out.println("Welcome to Hero World! ");
        System.out.println(); // Line break for readability
        int userChoice;
        do {
            System.out.println("""
                     1. Create New Hero
                     2. See Hero Registry
                     3. Search Hero Registry by Hero Name
                     4. Search Heroes by Powers
                     5. Edit A Hero
                     6. Delete A Hero
                     7. Leave Hero World.
                    """);
            userChoice = inputHelper.promptInt("Enter your choice (1-7):");


            switch (userChoice) {
                case 1 -> {
                    System.out.println("Let's Create A New Hero, Press Enter To Continue!");
                    keyboard.nextLine(); // Line Consumed for readability
                    System.out.println(); // Line break for readability
                    String name = inputHelper.promptString("Input Hero Moniker: ");
                    String realName = inputHelper.promptString("Input Real Name: ");
                    // Calling the editSuperPowers method to set powers
                    EnumSet<Hero.SuperPower> heroPowers = editSuperPowers(null, inputHelper);
                    String uniquePowers = inputHelper.promptString("Input any unique powers not listed: ");


                    int yearCreated = inputHelper.promptInt("Input Year Created: ");
                    double strength = inputHelper.promptDouble("Input Strength Number: ");
                    boolean isHuman = inputHelper.promptBoolean("Is the Hero Human, y/n?");

                    Hero newHero = new Hero(name, realName, heroPowers, yearCreated, isHuman, strength, uniquePowers);
                    db.addHero(newHero);
                    System.out.println("Thank You. Your Hero Has Been Registered ");
                    System.out.println(); // Line break for readability
                    System.out.println(newHero);
                    System.out.println(); // Line break for readability


                }
                case 2 -> {
                    System.out.println("Our Registered Heroes: ");
                    System.out.println();
                    ArrayList<Hero> heroesList = controller.getHeroesList();
                    
                    heroesList.sort(Comparator.comparing(Hero::getName));
                    
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

                        // Sort the matchingHeroes list alphabetically by hero name
                        matchingHeroes.sort(Comparator.comparing(Hero::getName));

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
                    EnumSet<Hero.SuperPower> searchPowers = EnumSet.noneOf(Hero.SuperPower.class);
                    System.out.println("Select the first superpower to search for:");
                    searchPowers.add(selectSuperPower(inputHelper));  // Pass inputHelper to the method
                    System.out.println("Would you like to add a second superpower to your search? (y/n)");
                    String addSecondPower = inputHelper.promptString("");
                    if (addSecondPower.equalsIgnoreCase("y")) {
                        System.out.println("Select the second superpower to search for:");
                        searchPowers.add(selectSuperPower(inputHelper)); // Pass inputHelper to the method
                    }
                    List<Hero> foundHeroes = Controller.searchHeroesByPowers(db.heroesList(), searchPowers);
                    System.out.println("Found heroes with the selected superpowers: " + foundHeroes);
                }

                case 5 -> {
                    System.out.println("Please Input Hero Name to Edit: ");
                    String heroNameToEdit = inputHelper.promptString("");

                    Hero heroToEdit = db.findHero(heroNameToEdit);

                    if (heroToEdit != null) {
                        System.out.println(); // Line break for readability
                        String newName = inputHelper.promptString("Enter new Hero Moniker: ");
                        System.out.println();
                        String newRealName = inputHelper.promptString("Enter new Real Name: ");
                        System.out.println();

                        // Edit the hero's superpowers using the editSuperPowers method
                        EnumSet<Hero.SuperPower> newSuperPowers = editSuperPowers(heroToEdit.getSuperPowers(), inputHelper);

                        String uniquePowers = inputHelper.promptString("Input any unique powers not listed: ");
                        System.out.println();
                        int newYearCreated = inputHelper.promptInt("Enter new Year Created: ");
                        System.out.println();
                        double newStrength = inputHelper.promptDouble("Enter new Strength Number: ");
                        System.out.println();
                        boolean newIsHuman = inputHelper.promptBoolean("Is the Hero Human? Input y/n: ");

                        // Update the Hero's attributes
                        db.updateHero(heroNameToEdit, newName, newRealName, newSuperPowers, newYearCreated, newIsHuman, newStrength, uniquePowers);
                        heroToEdit.setName(newName);

                        Hero updatedHero = db.findHero(newName); // Displaying the updated Hero's details, note that updatedHero is only named so for readability.
                        System.out.println("Your Hero Has Been Updated,");
                        System.out.println(); // Line break for readability
                    } else {
                        System.out.println("Hero not found.");
                    }
                }

                case 6 -> {
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
                case 7 -> {
                    System.out.println("Do you wish to save the current list of heroes before exiting? (y/n): ");
                    String saveChoice = inputHelper.promptString("");
                    if (saveChoice.equalsIgnoreCase("y")) {
                        filehandler.saveToCsvFile(db.getHeroes()); // Make sure to replace 'fileHandler' with the instance of your FileHandler class
                        System.out.println("Heroes list has been saved.");
                    }
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
        } while (true);
    }
    private static final int POWERS_PER_PAGE = 6;

    private static void displaySuperPowersList(int currentPage, Hero.SuperPower[] allPowers, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println((i - startIndex + 1) + ". " + Hero.formatSuperPower(allPowers[i]));
        }
        // Show previous page option if not on the first page
        if (currentPage > 0) {
            System.out.println("7. Previous Page");
        }
        // Show next page option if there are more powers
        if (endIndex < allPowers.length) {
            System.out.println("8. Next Page");
        }
        // Always show the done option
        System.out.println("9. Done");
    }


    public static EnumSet<Hero.SuperPower> editSuperPowers(EnumSet<Hero.SuperPower> currentPowers, InputHelper inputHelper) {
        EnumSet<Hero.SuperPower> heroPowers = currentPowers != null ? currentPowers : EnumSet.noneOf(Hero.SuperPower.class);
        int currentPage = 0;
        Hero.SuperPower[] allPowers = Hero.SuperPower.values();
        int totalPowers = allPowers.length;

        while (true) {
            int startIndex = currentPage * POWERS_PER_PAGE;
            int endIndex = Math.min(startIndex + POWERS_PER_PAGE, totalPowers);
            displaySuperPowersList(currentPage, allPowers, startIndex, endIndex);
            System.out.println("Current Powers: " + heroPowers);
            int powerChoice = inputHelper.promptInt("Choose an option by number: ");

            if (powerChoice >= 1 && powerChoice <= POWERS_PER_PAGE) {
                // Adjust the index to account for pagination
                int chosenIndex = startIndex + powerChoice - 1;
                if (chosenIndex < totalPowers) {
                    Hero.SuperPower chosenPower = allPowers[chosenIndex];
                    if (!heroPowers.contains(chosenPower)) {
                        heroPowers.add(chosenPower);
                        System.out.println(chosenPower.name() + " has been added!");
                    } else {
                        System.out.println("Power already added. Try again.");
                    }
                } else {
                    System.out.println("Invalid option. Try again.");
                }
            } else if (powerChoice == 7 && currentPage > 0) {
                currentPage--;
            } else if (powerChoice == 8 && endIndex < totalPowers) {
                currentPage++;
            } else if (powerChoice == 9) {
                System.out.println("Done with powers!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        return heroPowers;
    }

    private static Hero.SuperPower selectSuperPower(InputHelper inputHelper) {
        int currentPage = 0;
        Hero.SuperPower selectedPower = null;
        int totalPowers = Hero.SuperPower.values().length;

        while (selectedPower == null) {
            int startIndex = currentPage * POWERS_PER_PAGE;
            int endIndex = Math.min((currentPage + 1) * POWERS_PER_PAGE, totalPowers);

            // Display powers for the current page
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println((i - startIndex + 1) + ". " + Hero.SuperPower.values()[i]);
            }
            // Display navigation options
            if (currentPage > 0) {
                System.out.println("7. Previous Page");
            }
            if (endIndex < totalPowers) {
                System.out.println("8. Next Page");
            }
            System.out.println("9. Done");

            // Get user input
            int powerChoice = inputHelper.promptInt("Choose a superpower by number or navigate: ");

            // Logic for handling the user's selection or navigation
            if (powerChoice >= 1 && powerChoice <= POWERS_PER_PAGE && (startIndex + powerChoice - 1) < totalPowers) {
                selectedPower = Hero.SuperPower.values()[startIndex + powerChoice - 1];
            } else if (powerChoice == 7 && currentPage > 0) {
                currentPage--;
            } else if (powerChoice == 8 && endIndex < totalPowers) {
                currentPage++;
            } else if (powerChoice == 9) {
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        return selectedPower;
    }

}