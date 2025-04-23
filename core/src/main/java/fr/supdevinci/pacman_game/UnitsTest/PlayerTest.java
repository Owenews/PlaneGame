/*package fr.supdevinci.pacman_game.UnitsTest;

import fr.supdevinci.pacman_game.obj.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;*/



/**
 * Unit tests for the Player class.
 */
/*public class PlayerTest {

    @Test
    public void testInitialPlayerState() {
        Player player = new Player();
        assertTrue(player.isAlive(), "Player should be alive initially");
        assertEquals(0, player.getX(), "Initial X position should be 0");
        assertEquals(0, player.getY(), "Initial Y position should be 0");
        assertEquals(0, player.getAngle(), "Initial angle should be 0");
        assertEquals(0, player.getSpeed(), "Initial speed should be 0");
    }

    @Test
    public void testChangeLocation() {
        Player player = new Player();
        player.changeLocation(100, 200);
        assertEquals(100, player.getX(), "X position should be updated to 100");
        assertEquals(200, player.getY(), "Y position should be updated to 200");
    }

    @Test
    public void testChangeAngle() {
        Player player = new Player();
        player.changeAngle(90);
        assertEquals(90, player.getAngle(), "Angle should be updated to 90");

        player.changeAngle(-10);
        assertEquals(359, player.getAngle(), "Angle should wrap around to 359 when negative");

        player.changeAngle(360);
        assertEquals(0, player.getAngle(), "Angle should wrap around to 0 when exceeding 359");
    }

    @Test
    public void testSpeedUp() {
        Player player = new Player();
        player.speedUp();
        assertTrue(player.getSpeed() > 0, "Speed should increase when speedUp is called");
        assertTrue(player.getSpeed() <= player.getMaxSpeed(), "Speed should not exceed maximum speed");
    }

    @Test
    public void testSpeedDown() {
        Player player = new Player();
        player.speedUp();
        player.speedDown();
        assertTrue(player.getSpeed() >= 0, "Speed should decrease when speedDown is called");
    }

    @Test
    public void testUpdatePosition() {
        Player player = new Player();
        player.changeLocation(0, 0);
        player.setSpeed(1f);
        player.changeAngle(0);
        player.update();
        assertEquals(1, player.getX(), "X position should be updated based on speed and angle");
        assertEquals(0, player.getY(), "Y position should remain unchanged when angle is 0");

        player.changeAngle(90);
        player.update();
        assertEquals(1, player.getX(), "X position should remain unchanged when moving vertically");
        assertTrue(player.getY() > 0, "Y position should increase when angle is 90");
    }

    @Test
    public void testReset() {
        Player player = new Player();
        player.changeLocation(100, 200);
        player.changeAngle(90);
        player.speedUp();
        player.setAlive(false);

        player.reset();
        assertTrue(player.isAlive(), "Player should be alive after reset");
        assertEquals(0, player.getX(), "X position should be reset to 0");
        assertEquals(0, player.getY(), "Y position should be reset to 0");
        assertEquals(0, player.getAngle(), "Angle should be reset to 0");
        assertEquals(0, player.getSpeed(), "Speed should be reset to 0");
    }
}*/