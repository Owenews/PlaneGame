package fr.supdevinci.pacman_game.obj.sound;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Sound class is responsible for managing and playing sound effects in the game.
 * It provides methods to play specific sounds such as shooting, hitting, and destroying.
 */
public class Sound {

    
    private final URL shoot; // Sound for shooting
    private final URL hit; // Sound for hitting
    private final URL destroy; // Sound for destroying

    public Sound() {
        this.shoot = this.getClass().getClassLoader().getResource("fr/supdevinci/pacman_game/obj/sound/shoot.wav");
        this.hit = this.getClass().getClassLoader().getResource("fr/supdevinci/pacman_game/obj/sound/hit.wav");
        this.destroy = this.getClass().getClassLoader().getResource("fr/supdevinci/pacman_game/obj/sound/destroy.wav");
    }

    /**
     * Plays the shooting sound effect.
     */
    public void soundShoot() {
        play(shoot);
    }

    /**
     * Plays the hitting sound effect.
     */
    public void soundHit() {
        play(hit);
    }

    /**
     * Plays the destroying sound effect.
     */
    public void soundDestroy() {
        play(destroy);
    }

    /**
     * Plays a sound effect from the specified URL.
     * 
     * @param url The URL of the sound file to play.
     */
    private void play(URL url) {
        try {
            // Load the audio input stream from the URL
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            // Create a clip to play the sound
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            // Add a listener to close the clip when the sound finishes playing
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });

            // Close the audio input stream and start playing the sound
            audioIn.close();
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            // Print an error message if the sound cannot be played
            System.err.println(e);
        }
    }
}