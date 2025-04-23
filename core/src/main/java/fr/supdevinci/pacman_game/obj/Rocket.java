package fr.supdevinci.pacman_game.obj;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import javax.swing.ImageIcon;

/**
 * The Rocket class represents an enemy rocket in the game.
 * It handles the rocket's position, movement, rendering, and collision detection.
 */
public class Rocket extends HpRender {

    // Constants
    public static final double ROCKET_SIZE = 50; // Size of the rocket

    // Rocket attributes
    private double x; // X-coordinate of the rocket
    private double y; // Y-coordinate of the rocket
    private final float speed = 0.3f; // Speed of the rocket
    private float angle = 0; // Current angle of the rocket
    private final Image image; // Image representing the rocket
    private final Area rocketShap; // Shape of the rocket for collision detection

    /**
     * Constructor for the Rocket class.
     * Initializes the rocket's attributes and shape.
     */
    public Rocket() {
        super(new HP(20, 20)); // Initialize the rocket's health points
        this.image = new ImageIcon(getClass().getResource("/fr/supdevinci/pacman_game/image/rocket.png")).getImage();

        // Define the rocket's shape for collision detection
        Path2D p = new Path2D.Double();
        p.moveTo(0, ROCKET_SIZE / 2);
        p.lineTo(15, 10);
        p.lineTo(ROCKET_SIZE - 5, 13);
        p.lineTo(ROCKET_SIZE + 10, ROCKET_SIZE / 2);
        p.lineTo(ROCKET_SIZE - 5, ROCKET_SIZE - 13);
        p.lineTo(15, ROCKET_SIZE - 10);
        rocketShap = new Area(p);
    }

    /**
     * Changes the rocket's location.
     * @param x The new X-coordinate.
     * @param y The new Y-coordinate.
     */
    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the rocket's position based on its speed and angle.
     */
    public void update() {
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    /**
     * Changes the rocket's angle.
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
     * Draws the rocket on the screen.
     * @param g2 The graphics context.
     */
    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x, y);
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(angle + 45), ROCKET_SIZE / 2, ROCKET_SIZE / 2);
        g2.drawImage(image, tran, null);
        Shape shap = getShape();
        hpRender(g2, shap, y); // Render the rocket's health bar
        g2.setTransform(oldTransform);

        // Uncomment the following lines to visualize the rocket's shape for debugging
        // g2.setColor(new Color(36, 214, 63));
        // g2.draw(shap);
        // g2.draw(shap.getBounds2D());
    }

    /**
     * Gets the rocket's X-coordinate.
     * @return The X-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the rocket's Y-coordinate.
     * @return The Y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the rocket's current angle.
     * @return The angle in degrees.
     */
    public float getAngle() {
        return angle;
    }

    /**
     * Gets the rocket's shape for collision detection.
     * @return The rocket's shape as an Area object.
     */
    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(x, y);
        afx.rotate(Math.toRadians(angle), ROCKET_SIZE / 2, ROCKET_SIZE / 2);
        return new Area(afx.createTransformedShape(rocketShap));
    }

    /**
     * Checks if the rocket is within the game boundaries.
     * @param width The width of the game area.
     * @param height The height of the game area.
     * @return True if the rocket is within the boundaries, false otherwise.
     */
    public boolean check(int width, int height) {
        Rectangle size = getShape().getBounds();
        if (x <= -size.getWidth() || y < -size.getHeight() || x > width || y > height) {
            return false;
        } else {
            return true;
        }
    }
}