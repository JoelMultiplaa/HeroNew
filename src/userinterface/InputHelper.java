package userinterface;

import java.util.Scanner;

public class InputHelper {
    private final Scanner keyboard;

    public InputHelper(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public String promptString(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return keyboard.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                // Line break added for readability
                System.out.println();
            }
        }
    }

    public int promptInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                // Line break added for readability
                System.out.println();
            }
        }
    }
    public boolean promptBoolean(String prompt) {
        while (true) {
            try {
                // Viser prompt besked til brugeren
                System.out.println(prompt);
                // Læser brugerinput og konverterer det til små bogstaver for at undgå forskelle i store og små bogstaver
                String input = keyboard.nextLine().toLowerCase();
                // Tjekker om input er 'y' eller 'yes', returner true
                if (input.equals("y") || input.equalsIgnoreCase("yes")) {
                    return true;
                    //Tjekker om input er 'n' eller 'no', returner false
                } else if (input.equals("n") || input.equalsIgnoreCase("no")) {
                    return false;
                    // Viser en fejlmeddelelse for ugyldig input
                } else {
                    System.out.println("Invalid input. Please enter 'y'/'yes' if human or 'n'/'no' if non-human.");
                    System.out.println();
                }
            }
            // Viser en fejlmeddelelse for ugyldig input
            catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
            }
        }
    }

    public double promptDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = keyboard.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                // Line break added for readability
                System.out.println();
            }
        }
    }

}
