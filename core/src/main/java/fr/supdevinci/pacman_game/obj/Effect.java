package fr.supdevinci.pacman_game.obj;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * The Effect class represents an explosion effect in the game.
 * It handles the creation, rendering, and animation of explosion particles.
 */
public class Effect {

    private final double x; 
    private final double y;
    private final double max_distance; 
    private final int max_size; 
    private final Color color; 
    private final int totalEffect; 
    private final float speed; 
    private double current_distance; 
    private ModelBoom[] booms; 
    private float alpha = 1f; 

    /**
     * Constructor for the Effect class.
     * Initializes the explosion effect with the specified parameters.
     * 
     * @param x The X-coordinate of the explosion's origin.
     * @param y The Y-coordinate of the explosion's origin.
     * @param totalEffect The total number of particles in the explosion.
     * @param max_size The maximum size of the particles.
     * @param max_distance The maximum distance the particles can travel.
     * @param speed The speed of the particles.
     * @param color The color of the explosion particles.
     */
    public Effect(double x, double y, int totalEffect, int max_size, double max_distance, float speed, Color color) {
        this.x = x;
        this.y = y;
        this.totalEffect = totalEffect;
        this.max_size = max_size;
        this.max_distance = max_distance;
        this.speed = speed;
        this.color = color;
        createRandom(); // Generate random particles for the explosion
    }

    /**
     * Creates random particles for the explosion effect.
     */
    private void createRandom() {
        booms = new ModelBoom[totalEffect];
        float per = 360f / totalEffect; // Divide the circle into equal angles for particles
        Random ran = new Random();
        for (int i = 1; i <= totalEffect; i++) {
            int r = ran.nextInt((int) per) + 1; // Randomize the angle slightly
            int boomSize = ran.nextInt(max_size) + 1; // Randomize the size of the particle
            float angle = i * per + r; // Calculate the angle for the particle
            booms[i - 1] = new ModelBoom(boomSize, angle); // Create a new particle
        }
    }

    /**
     * Draws the explosion effect on the screen.
     * 
     * @param g2 The graphics context used for rendering.
     */
    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        Composite oldComposite = g2.getComposite();
        g2.setColor(color);
        g2.translate(x, y); // Translate to the explosion's origin
        for (ModelBoom b : booms) {
            double bx = Math.cos(Math.toRadians(b.getAngle())) * current_distance; // X-coordinate of the particle
            double by = Math.sin(Math.toRadians(b.getAngle())) * current_distance; // Y-coordinate of the particle
            double boomSize = b.getSize(); // Size of the particle
            double space = boomSize / 2; // Offset to center the particle
            if (current_distance >= max_distance - (max_distance * 0.7f)) {
                alpha = (float) ((max_distance - current_distance) / (max_distance * 0.7f)); // Adjust transparency
            }
            if (alpha > 1) {
                alpha = 1;
            } else if (alpha < 0) {
                alpha = 0;
            }
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); // Set transparency
            g2.fill(new Rectangle2D.Double(bx - space, by - space, boomSize, boomSize)); // Draw the particle
        }
        g2.setComposite(oldComposite); // Restore the original composite
        g2.setTransform(oldTransform); // Restore the original transform
    }

    /**
     * Updates the explosion effect by increasing the distance traveled by the particles.
     */
    public void update() {
        current_distance += speed;
    }

    /**
     * Checks if the explosion effect is still active.
     * 
     * @return True if the particles have not reached their maximum distance, false otherwise.
     */
    public boolean check() {
        return current_distance < max_distance;
    }

    /**
     * Gets the current distance traveled by the particles.
     * 
     * @return The current distance.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y-coordinate of the explosion's origin.
     * 
     * @return The Y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the maximum distance the particles can travel.
     * 
     * @return The maximum distance.
     */
    public double getMax_distance() {
        return max_distance;
    }

    /**
     * Gets the maximum size of the particles.
     * 
     * @return The maximum size.
     */
    public int getMax_size() {
        return max_size;
    }
    

    /**
     * Gets the color of the explosion particles.
     * 
     * @return The color.
     */
    public Color getColor() {
        return color;
    }
    

    /**
     * Gets the total number of particles in the explosion.
     * 
     * @return The total number of particles.
     */
    public int getTotalEffect() {
        return totalEffect;
    }

    /**
     * Gets the speed of the particles.
     * 
     * @return The speed.
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Gets the current distance traveled by the particles.
     * 
     * @return The current distance.
     */
    public double getCurrent_distance() {
        return current_distance;
    }

    /**
     * Sets the current distance traveled by the particles.
     * 
     * @param current_distance The new current distance.
     * @return The updated current distance.
     */
    public double setCurrent_distance(double current_distance) {
        this.current_distance = current_distance;
        return current_distance;
    }
    
}