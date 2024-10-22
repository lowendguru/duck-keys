package soundplayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    // Method to play a sound file
    public static void playSound(String filePath) {
        try {
            // Create a File object from the file path
            File soundFile = new File(filePath);

            // Open an audio input stream from the file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource
            Clip clip = AudioSystem.getClip();

            // Open the audio clip and load the audio data from the audio input stream
            clip.open(audioStream);

            // Start playing the sound
            clip.start();

            // Keep the program running until the sound is finished
            System.out.println("Playing sound: " + filePath);
            Thread.sleep(clip.getMicrosecondLength() / 1000);

            // Close the clip after playback is done
            clip.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file format is not supported.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.out.println("Audio line for playback is unavailable.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error playing the audio file.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Playback was interrupted.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage: Play a sound file
        String filePath = "resources/cuac.wav"; // Update this with your sound file path
        playSound(filePath);
    }
}
