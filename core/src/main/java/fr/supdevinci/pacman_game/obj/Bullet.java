package fr.supdevinci.pacman_game.obj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 * The Bullet class represents a projectile fired by the player.
 * It handles the bullet's position, movement, rendering, and collision detection.
 */
public class Bullet {

    private double x;
    private double y; 
    private final Shape shape; 
    private final Color color = new Color(255, 255, 255); 
    private final float angle; 
    private double size; 
    private float speed = 1f;


    public Bullet(double x, double y, float angle, double size, float speed) {
        // Adjust the initial position to center the bullet relative to the player
        x += Player.PLAYER_SIZE / 2 - (size / 2);
        y += Player.PLAYER_SIZE / 2 - (size / 2);
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.size = size;
        this.speed = speed;

        // Define the bullet's shape as a circle
        shape = new Ellipse2D.Double(0, 0, size, size);
    }

    /**
     * Updates the bullet's position based on its speed and angle.
     */
    public void update() {
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    /**
     * Checks if the bullet is within the game boundaries.
     * 
     * @param width The width of the game area.
     * @param height The height of the game area.
     * @return True if the bullet is within the boundaries, false otherwise.
     */
    public boolean check(int width, int height) {
        if (x <= -size || y < -size || x > width || y > height) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Draws the bullet on the screen.
     * 
     * @param g2 The graphics context used for rendering.
     */
    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.setColor(color);
        g2.translate(x, y);
        g2.fill(shape);
        g2.setTransform(oldTransform);
    }

    /**
     * Gets the shape of the bullet for collision detection.
     * 
     * @return The shape of the bullet as an Area object.
     */
    public Shape getShape() {
        return new Area(new Ellipse2D.Double(x, y, size, size));
    }

    /**
     * Gets the X-coordinate of the bullet.
     * 
     * @return The X-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y-coordinate of the bullet.
     * 
     * @return The Y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the size of the bullet.
     * 
     * @return The size of the bullet.
     */
    public double getSize() {
        return size;
    }

    /**
     * Gets the X-coordinate of the bullet's center.
     * 
     * @return The X-coordinate of the center.
     */
    public double getCenterX() {
        return x + size / 2;
    }

    /**
     * Gets the Y-coordinate of the bullet's center.
     * 
     * @return The Y-coordinate of the center.
     */
    public double getCenterY() {
        return y + size / 2;
    }

    /**
     * Sets the bullet's speed.
     * 
     * @param speed The new speed of the bullet.
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Sets the bullet's size.
     * 
     * @param size The new size of the bullet.
     */
    public void setSize(double size) {
        this.size = size;
    }
}