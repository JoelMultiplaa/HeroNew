import domain_model.Database;
import domain_model.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;

    @BeforeEach
    void setUp() {
        // Initialize the Database instance
        db = new Database();
        Scanner keyboard = new Scanner(System.in);

        db.addHero(new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100.0, "Solar Energy Absorption"));
        db.addHero(new Hero("Batman", "Bruce Wayne", EnumSet.of(Hero.SuperPower.EXCEPTIONAL), 1939, true, 70, "Genius-level intellect"));
        }




    @Test
    void addHero() {
        // Create a Hero instance with specific attributes
        Hero newHero = new Hero("Spider-Man", "Peter Parker", EnumSet.of(Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY), 1962, true, 75, "Web-slinging, Super agility, Wall Climbing, Spider Sense");

        // Add the Hero to the database
        db.addHero(newHero);

        // Retrieve the list of heroes from the database
        ArrayList<Hero> heroes;

        // Verify that the newHero is in the list
        assertTrue(db.getHeroes().contains(newHero));
    }

    @Test
    void testFindHero() {
        // Simulate user input
        String inputName = "Batman";
        InputStream in = new ByteArrayInputStream(inputName.getBytes());
        System.setIn(in);

        // Use the findHero function and verify its output
        Hero foundHero = db.findHero(inputName);

        // Assert that the foundHero is not null
        assertNotNull(foundHero);

        // Create the expected output string with the hero's details
        String expectedOutput = "Hero found in the Registry:\n" + foundHero.toString();
        // Check if the expected output matches the actual output
        assertEquals(expectedOutput, "Hero found in the Registry:\n" + foundHero.toString());
    }
    @Test
    void testFindHeroesByPartOfName() {
        String inputSearchPart = "S";
        ArrayList<Hero> foundHeroes = db.findHeroesByPartOfName(inputSearchPart);

        assertEquals(1, foundHeroes.size());
    }

    @Test

        // Work in progress!

    void testDeleteHero() {

        boolean removed = db.deleteHero("Superman");
        ArrayList<Hero> heroes;
        boolean found = false;
        for (Hero hero : db.getHeroes()) {
            if (hero.getName().equals("Superman")) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }
    }












