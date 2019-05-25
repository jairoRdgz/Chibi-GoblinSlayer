package threads;

import ui.GameController;;

public class AtackThread extends Thread{
	
	private GameController game;
	
	public AtackThread(GameController gui) {
		game = gui;
	}
	
	public void run() {
		
		game.atack(1);
		try {
			sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.atack(2);
		
	}
	
}
