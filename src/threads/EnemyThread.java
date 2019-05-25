package threads;

import java.util.Random;

import ui.GameController;

public class EnemyThread extends Thread{
	
	private GameController game;
	private boolean alive;
	
	public EnemyThread(GameController gui, boolean live) {
		game = gui;
		alive = live;
	}
	
	public void Run() {
		while(alive) {
			Random rnd = new Random();
			int move = rnd.nextInt(4);
			game.moveGoblin(move);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
