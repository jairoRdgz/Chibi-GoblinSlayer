package model;

import java.util.Random;

public class Level {
	private Player player;
	private Enemy[] enemies;
	private Object[] objects;
	
	public Level() {

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
	
	public void createPlayer() {
		//tener en cuenta el tamaño del jugador y la posicion de inicio siempre seran las mismas
		player = new Player(20, 20, 53, 78);
	}
	
	public void createEnemies() {
		
		Random rnd = new Random();
		enemies = new Enemy[rnd.nextInt(20)];
	}
	
	public void createObjects() {
		Random rnd = new Random();
		objects = new Object[rnd.nextInt(7)];
	}
}
