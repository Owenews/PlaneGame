/*package fr.supdevinci.pacman_game.UnitsTest;

import fr.supdevinci.pacman_game.obj.Rocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;*/
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertFalse;

/*class RocketTest {

    private Rocket rocket;

    @BeforeEach
    void setUp() {
        rocket = new Rocket();
    }

    @Test
    void testChangeLocation() {
        rocket.changeLocation(100, 200);
        assertEquals(100, rocket.getX(), 0.001); // Allowing for floating-point precision
        assertEquals(200, rocket.getY(), 0.001);
    }

    @Test
    void testUpdate() {
        rocket.changeLocation(0, 0);
        rocket.changeAngle(0);
        rocket.update();
        assertEquals(0.3, rocket.getX(), 0.001); // Speed is 0.3, angle is 0
        assertEquals(0, rocket.getY(), 0.001);
    }

    @Test
    void testChangeAngle() {
        rocket.changeAngle(-10);
        assertEquals(359, rocket.getAngle(), 0.001);

        rocket.changeAngle(370);
        assertEquals(0, rocket.getAngle(), 0.001);
    }

    @Test
    void testCheckWithinBounds() {
        rocket.changeLocation(50, 50);
        assertTrue(rocket.check(100, 100));
    }

    @Test
    void testCheckOutOfBounds() {
        rocket.changeLocation(-10, -10);
        assertFalse(rocket.check(100, 100));
    }
}*/