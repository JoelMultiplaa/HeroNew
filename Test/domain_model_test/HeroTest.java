import domain_model.Hero;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HeroTest {
    @Test
    void testGetName() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        assertEquals("Superman", hero.getName());
    }

    @Test
    void testSetName() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        hero.setName("Bizarro");
        assertEquals("Bizarro", hero.getName());
    }

    @Test
    void testGetRealName() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        assertEquals("Clark Kent", hero.getRealName());
    }

    @Test
    void testSetRealName() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        hero.setRealName("Kal El");
        assertEquals("Kal El", hero.getRealName());
    }

    @Test
    void testSetYearCreated() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        hero.setYearCreated(1940);
        assertEquals(1940, hero.getYearCreated());
    }

    @Test
    void testSetIsHuman() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        hero.setIsHuman(true);
        assertTrue(hero.isHuman());
    }

    @Test
    void testSetStrength() {
        Hero hero = new Hero("Superman", "Clark Kent", EnumSet.of(Hero.SuperPower.FLIGHT, Hero.SuperPower.SUPER_STRENGTH, Hero.SuperPower.INVULNERABILITY, Hero.SuperPower.SUPER_SPEED, Hero.SuperPower.OCULAR_POWERS), 1938, false, 100, "Solar Energy Absorption");
        hero.setStrength(90.5);
        assertEquals(90.5, hero.getStrength(), 0.001); // delta for double comparison (read up on delta!)
    }
}
