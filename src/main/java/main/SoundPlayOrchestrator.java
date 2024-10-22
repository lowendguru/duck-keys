package main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import soundplayer.SoundPlayerThread;

public class SoundPlayOrchestrator implements Runnable {

	BlockingQueue<Boolean> cola = new LinkedBlockingQueue<>();

	public SoundPlayOrchestrator(BlockingQueue<Boolean> cola) {
		this.cola = cola;
	}

	@Override
	public void run() {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		while (true) {
			try {
				System.out.println("espeando cola");
				cola.take();
				System.out.println("sacando item de cola");
				executor.execute(new SoundPlayerThread());
				//new SoundPlayerThread().run();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
