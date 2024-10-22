package listener;

import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalKeyboardListener {

	public GlobalKeyboardListener() {

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

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				System.out.println(event);
			}
		});

	}

}