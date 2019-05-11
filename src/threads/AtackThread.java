package threads;

import ui.GameController;

public class AtackThread extends Thread{
	
	private GameController gui;
	
	public AtackThread(GameController g) {
		gui = g;
	}

	public void Run() {
		gui.atack(1);
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gui.atack(2);
	}
}
