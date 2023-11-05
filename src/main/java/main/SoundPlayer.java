package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	
	
	public static void main(String[] args) {
	playSound();
	}

	public static synchronized void playSound() {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		    	
		 
		    	
		      try {
		        Clip clip = AudioSystem.getClip();
		        
		        
		        AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream("/resources/cuac.wav"));
		     //   AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        	
		        		
		        	//	SoundPlayer.class.getResourceAsStream("cuac.wav"));
		        clip.open(audioStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	
}
