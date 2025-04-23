package fr.supdevinci.pacman_game.obj;

/**
 * The HP class represents the health points (HP) of an entity in the game.
 * It provides methods to manage and retrieve the maximum and current HP values.
 */
public class HP {

    private double MAX_HP;
    private double currentHp;

    /**
     * Constructor for the HP class.
     * Initializes the maximum and current health points.
     * 
     * @param MAX_HP The maximum health points.
     * @param currentHp The current health points.
     */
    public HP(double MAX_HP, double currentHp) {
        this.MAX_HP = MAX_HP;
        this.currentHp = currentHp;
    }

    public HP() {
    }

    /**
     * Gets the maximum health points of the entity.
     * 
     * @return The maximum health points.
     */
    public double getMAX_HP() {
        return MAX_HP;
    }

    /**
     * Sets the maximum health points of the entity.
     * 
     * @param MAX_HP The new maximum health points.
     */
    public void setMAX_HP(double MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    /**
     * Gets the current health points of the entity.
     * 
     * @return The current health points.
     */
    public double getCurrentHp() {
        return currentHp;
    }

    /**
     * Sets the current health points of the entity.
     * 
     * @param currentHp The new current health points.
     */
    public void setCurrentHp(double currentHp) {
        this.currentHp = currentHp;
    }
}