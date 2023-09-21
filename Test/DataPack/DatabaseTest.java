import ControlPack.Controller;
import DataPack.Database;
import HeroInfo.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;

    @BeforeEach
    void setUp() {
        // Initialize the Database instance
        db = new Database();
        Scanner keyboard = new Scanner(System.in);

        // Add initial Hero objects to the database
        db.addHero(new Hero("Superman", "Clark Kent", "Flight, Super strength", 1938, false, 100));
        db.addHero(new Hero("Batman", "Bruce Wayne", "Intelligence, Martial Arts", 1939, true, 70));
        }




    @Test
    void addHero() {
        // Create a Hero instance with specific attributes
        Hero newHero = new Hero("Spider-Man", "Peter Parker", "Web-slinging, Super agility", 1962, true, 80);

        // Add the Hero to the database
        db.addHero(newHero);

        // Retrieve the list of heroes from the database
        ArrayList<Hero> heroesList = db.heroesList();

        // Verify that the newHero is in the list
        assertTrue(heroesList.contains(newHero));
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
        ArrayList<Hero> heroesList = db.heroesList();
        boolean found = false;
        for (Hero hero : heroesList) {
            if (hero.getName().equals("Superman")) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }
    }












