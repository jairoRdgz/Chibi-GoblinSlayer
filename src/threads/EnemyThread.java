package threads;

import java.util.Random;

import model.Enemy;
import ui.GameController;

public class EnemyThread extends Thread{
	
	private GameController game;
	private Enemy enemy;
	private boolean alive;
	
	public EnemyThread(GameController gui, boolean live, Enemy en) {
		game = gui;
		alive = live;
		enemy = en;
	}
	
	@Override
	public void run() {
		System.out.println("RUN");
		while(alive) {
			Random rnd = new Random();
			int move = rnd.nextInt(4);
			System.out.println("MOVE");
			enemy.moveGoblin(move, (int)game.getWith(), (int)game.getHeigth());
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
