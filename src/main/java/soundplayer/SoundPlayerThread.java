package soundplayer;

public class SoundPlayerThread implements Runnable {

	@Override
	public void run() {
		String filePath = "resources/cuac.wav"; // Update this with your sound file path
		SoundPlayer.playSound(filePath);

	}

}
