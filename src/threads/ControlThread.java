package threads;

import javafx.application.Platform;
import ui.GameController;

public class ControlThread extends Thread{
	
	private GameController gc;
	
	public ControlThread(GameController gc) {
		this.gc = gc;
	}
	
	@Override
	public void run() {
		while (true) {
			GUIMovingEnemy pt = new GUIMovingEnemy(gc);
			Platform.runLater(pt);

			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
