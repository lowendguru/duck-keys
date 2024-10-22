package listener;

import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalKeyboardListener {

	public GlobalKeyboardListener(BlockingQueue<Boolean> cola) {

		// might throw a UnsatisfiedLinkError if the native library fails to load or a
		// RuntimeException if hooking fails
		// use false here to switch to hook instead of raw input
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

		System.out.println("Global keyboard hook successfully started. Connected keyboards:");
		for (Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());

		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				System.out.println(event);
				System.out.println("event:" + event.getVirtualKeyCode());

				// TODO play sound
				// new SoundPlayerThread().run();
				System.out.println("agregando a la cola");
				cola.add(true);
				System.out.println("COLA SIZE: " + cola.size());
			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				System.out.println(event);
			}
		});

	}

}