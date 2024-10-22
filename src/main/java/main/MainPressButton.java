package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MainPressButton {

	public static void main(String[] args) {
		try {
			Robot r = new Robot();

			while (true) {
//				r.keyPress(KeyEvent.VK_SPACE);
//				Thread.sleep(1);
//				r.keyRelease(KeyEvent.VK_SPACE);
//				Thread.sleep(1);
				
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(1);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(1);
				
				
			}

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
