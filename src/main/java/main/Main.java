package main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import listener.GlobalKeyboardListener;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlockingQueue<Boolean> cola = new LinkedBlockingQueue<>();
		System.out.println("1");

		SoundPlayOrchestrator soundOrchestrator = new SoundPlayOrchestrator(cola);
		Thread soundOrchestratorThread = new Thread(soundOrchestrator);
		soundOrchestratorThread.start();

		System.out.println("2");
		new GlobalKeyboardListener(cola);

	}

}
