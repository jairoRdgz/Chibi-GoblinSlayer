package model;

import java.util.Random;

public class Level {
	private Player player;
	private Enemy[] enemies;
	private Object[] objects;
	
	public Level() {
		player = createNewPlayer();
	}

	public Player getPlayer() {
		return player;
	}

	public Enemy[] getEnemys() {
		return enemies;
	}

	public Object[] getObjects() {
		return objects;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEnemys(Enemy[] enemys) {
		this.enemies = enemys;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	
	public Player createNewPlayer() {
		Player player = new Player(0.0, 0.0, 53.0, 78.0);
		return player;
	}
	
	public Enemy[] createEnemies() {
		
		Random rnd = new Random();
		enemies = new Enemy[rnd.nextInt(5)];
		return enemies;
	}
	
	public Object[] createObjects() {
		Random rnd = new Random();
		objects = new Object[rnd.nextInt(7)];
		return objects;
	}
}
