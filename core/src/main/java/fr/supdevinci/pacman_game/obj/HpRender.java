package fr.supdevinci.pacman_game.obj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * The HpRender class is responsible for rendering and managing the health points (HP) of game objects.
 * It provides methods to display the HP bar, update the HP, and reset it.
 */
public class HpRender {

    // The HP object representing the health points of the entity
    private final HP hp;

    public HpRender(HP hp) {
        this.hp = hp;
    }

    /**
     * Renders the health bar of the entity above its shape.
     * 
     * @param g2 The graphics context used for rendering.
     * @param shape The shape of the entity.
     * @param y The Y-coordinate offset for positioning the health bar.
     */
    protected void hpRender(Graphics2D g2, Shape shape, double y) {
        // Check if the current HP is not equal to the maximum HP
        if (hp.getCurrentHp() != hp.getMAX_HP()) {
            // Calculate the Y-coordinate for the health bar
            double hpY = shape.getBounds().getY() - y - 10;

            // Draw the background of the health bar
            g2.setColor(new Color(70, 70, 70));
            g2.fill(new Rectangle2D.Double(0, hpY, Player.PLAYER_SIZE, 2));

            // Draw the foreground of the health bar representing the current HP
            g2.setColor(new Color(253, 91, 91));
            double hpSize = hp.getCurrentHp() / hp.getMAX_HP() * Player.PLAYER_SIZE;
            g2.fill(new Rectangle2D.Double(0, hpY, hpSize, 2));
        }
    }

    /**
     * Updates the current HP by reducing it by a specified amount.
     * 
     * @param cutHP The amount of HP to reduce.
     * @return True if the entity is still alive (HP > 0), false otherwise.
     */
    public boolean updateHP(double cutHP) {
        hp.setCurrentHp(hp.getCurrentHp() - cutHP);
        return hp.getCurrentHp() > 0;
    }

    /**
     * Gets the current HP of the entity.
     * 
     * @return The current HP.
     */
    public double getHP() {
        return hp.getCurrentHp();
    }

    /**
     * Resets the HP of the entity to its maximum value.
     */
    public void resetHP() {
        hp.setCurrentHp(hp.getMAX_HP());
    }
}