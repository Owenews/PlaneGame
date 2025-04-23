package fr.supdevinci.pacman_game.obj;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import javax.swing.ImageIcon;

/**
 * The Player class represents the player-controlled entity in the game.
 * It handles the player's position, movement, rendering, and interactions.
 */
public class Player extends HpRender {

    // Constants
    public static final double PLAYER_SIZE = 64; // Size of the player

    // Player attributes
    private double x; // X-coordinate of the player
    private double y; // Y-coordinate of the player
    private final float MAX_SPEED = 1f; // Maximum speed of the player
    private float speed = 0f; // Current speed of the player
    private float angle = 0f; // Current angle of the player
    private final Area playerShap; // Shape of the player for collision detection
    private final Image image; // Default player image
    private final Image image_speed; // Image displayed when the player speeds up
    private boolean speedUp; // Indicates if the player is speeding up
    private boolean alive = true; // Indicates if the player is alive


    public Player() {
        super(new HP(50, 50)); // Initialize the player's health points
        this.image = new ImageIcon(getClass().getResource("/fr/supdevinci/pacman_game/image/plane.png")).getImage();
        this.image_speed = new ImageIcon(getClass().getResource("/fr/supdevinci/pacman_game/image/plane_speed.png")).getImage();

        // Define the player's shape for collision detection
        Path2D p = new Path2D.Double();
        p.moveTo(0, 15);
        p.lineTo(20, 5);
        p.lineTo(PLAYER_SIZE + 15, PLAYER_SIZE / 2);
        p.lineTo(20, PLAYER_SIZE - 5);
        p.lineTo(0, PLAYER_SIZE - 15);
        playerShap = new Area(p);
    }

    /**
     * Changes the player's location.
     * @param x The new X-coordinate.
     * @param y The new Y-coordinate.
     */
    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the player's position based on its speed and angle.
     */
    public void update() {
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    /**
     * Changes the player's angle.
     * @param angle The new angle in degrees.
     */
    public void changeAngle(float angle) {
        if (angle < 0) {
            angle = 359;
        } else if (angle > 359) {
            angle = 0;
        }
        this.angle = angle;
    }

    /**
     * Draws the player on the screen.
     * @param g2 The graphics context.
     */
    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x, y);
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(angle + 45), PLAYER_SIZE / 2, PLAYER_SIZE / 2);
        g2.drawImage(speedUp ? image_speed : image, tran, null);
        hpRender(g2, getShape(), y); // Render the player's health bar
        g2.setTransform(oldTransform);

        // Uncomment the following lines to visualize the player's shape for debugging
        // g2.setColor(new Color(12, 173, 84));
        // g2.draw(getShape());
        // g2.draw(getShape().getBounds());
    }

    /**
     * Gets the player's shape for collision detection.
     * @return The player's shape as an Area object.
     */
    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(x, y);
        afx.rotate(Math.toRadians(angle), PLAYER_SIZE / 2, PLAYER_SIZE / 2);
        return new Area(afx.createTransformedShape(playerShap));
    }

    /**
     * Gets the player's X-coordinate.
     * @return The X-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the player's Y-coordinate.
     * @return The Y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the player's current angle.
     * @return The angle in degrees.
     */
    public float getAngle() {
        return angle;
    }

    /**
     * Gets the player's current speed.
     * @return The speed.
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Sets the player's speed.
     * @param speed The new speed.
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Gets the player's maximum speed.
     * @return The maximum speed.
     */
    public float getMaxSpeed() {
        return MAX_SPEED;
    }

    
    /**
     * Increases the player's speed up to the maximum speed.
     */
    public void speedUp() {
        speedUp = true;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        } else {
            speed += 0.01f;
        }
    }

    /**
     * Decreases the player's speed down to zero.
     */
    public void speedDown() {
        speedUp = false;
        if (speed <= 0) {
            speed = 0;
        } else {
            speed -= 0.003f;
        }
    }

    /**
     * Checks if the player is alive.
     * @return True if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Sets the player's alive status.
     * @param alive True if the player is alive, false otherwise.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Resets the player's state to its initial configuration.
     */
    public void reset() {
        alive = true;
        resetHP(); // Reset the player's health points
        angle = 0;
        speed = 0;
    }
}