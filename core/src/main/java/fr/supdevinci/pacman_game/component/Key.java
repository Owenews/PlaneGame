package fr.supdevinci.pacman_game.component;


public class Key {

    private boolean key_right;
    private boolean key_left;
    private boolean key_space;
    private boolean key_j;
    private boolean key_k;
    private boolean key_enter;

    /**
     * Checks if the "enter" key is pressed.
     * @return true if the "enter" key is pressed, false otherwise.
     */
    public boolean isKey_enter() {
        return key_enter;
    }

    /**
     * Sets the state of the "enter" key.
     * @param key_enter true if the "enter" key is pressed, false otherwise.
     */    
    public void setKey_enter(boolean key_enter) {
        this.key_enter = key_enter;
    }

    /**
     * Checks if the "right" key is pressed.
     * @return true if the "right" key is pressed, false otherwise.
     */
    public boolean isKey_right() {
        return key_right;
    }

    /**
     * Sets the state of the "right" key.
     * @param key_right true if the "right" key is pressed, false otherwise.
     */
    public void setKey_right(boolean key_right) {
        this.key_right = key_right;
    }

    /**
     * Checks if the "left" key is pressed.
     * @return true if the "left" key is pressed, false otherwise.
     */
    public boolean isKey_left() {
        return key_left;
    }

    /**
     * Sets the state of the "left" key.
     * @param key_left true if the "left" key is pressed, false otherwise.
     */
    public void setKey_left(boolean key_left) {
        this.key_left = key_left;
    }

    /**
     * Checks if the "space" key is pressed.
     * @return true if the "space" key is pressed, false otherwise.
     */
    public boolean isKey_space() {
        return key_space;
    }

    /**
     * Sets the state of the "space" key.
     * @param key_space true if the "space" key is pressed, false otherwise.
     */
    public void setKey_space(boolean key_space) {
        this.key_space = key_space;
    }

    /**
     * Checks if the "j" key is pressed.
     * @return true if the "j" key is pressed, false otherwise.
     */
    public boolean isKey_j() {
        return key_j;
    }

    /**
     * Sets the state of the "j" key.
     * @param key_j true if the "j" key is pressed, false otherwise.
     */
    public void setKey_j(boolean key_j) {
        this.key_j = key_j;
    }

    /**
     * Checks if the "k" key is pressed.
     * @return true if the "k" key is pressed, false otherwise.
     */
    public boolean isKey_k() {
        return key_k;
    }

    /**
     * Sets the state of the "k" key.
     * @param key_k true if the "k" key is pressed, false otherwise.
     */
    public void setKey_k(boolean key_k) {
        this.key_k = key_k;
    }
} 
