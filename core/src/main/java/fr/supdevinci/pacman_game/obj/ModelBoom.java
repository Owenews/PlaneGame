package fr.supdevinci.pacman_game.obj;

/**
 * The ModelBoom class represents a model for explosion effects in the game.
 * It contains attributes for the size and angle of the explosion.
 */
public class ModelBoom {

    private double size; 
    private float angle;

    /**
     * Constructor for the ModelBoom class.
     * Initializes the size and angle of the explosion.
     * 
     * @param size The size of the explosion.
     * @param angle The angle of the explosion.
     */
    public ModelBoom(double size, float angle) {
        this.size = size;
        this.angle = angle;
    }

    public ModelBoom() {
    }

    /**
     * Gets the size of the explosion.
     * 
     * @return The size of the explosion.
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the size of the explosion.
     * 
     * @param size The new size of the explosion.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Gets the angle of the explosion.
     * 
     * @return The angle of the explosion.
     */
    public float getAngle() {
        return angle;
    }

    /**
     * Sets the angle of the explosion.
     * 
     * @param angle The new angle of the explosion.
     */
    public void setAngle(float angle) {
        this.angle = angle;
    }
}