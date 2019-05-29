package model;

import java.util.Random;
/**
 * This class contains the attributes from the levels
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class Level {
	private Player player;
	private Enemy[] enemies;
	private Object[] objects;
	
	/**
	 * constructor
	 */
	public Level() {
		player = createNewPlayer();
	}

	/**
	 * gets the player
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * gets the enemy
	 * @return
	 */
	public Enemy[] getEnemys() {
		return enemies;
	}

	/**
	 * gets the objects
	 * @return
	 */
	public Object[] getObjects() {
		return objects;
	}

	/**
	 * sets the player
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * sets the enemy
	 * @param enemys
	 */
	public void setEnemys(Enemy[] enemys) {
		this.enemies = enemys;
	}

	/**
	 * sets the objects
	 * @param objects
	 */
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	
	/**
	 * this method create a new player
	 * @return
	 */
	public Player createNewPlayer() {
		Player player = new Player(0.0, 0.0, 53.0, 78.0);
		return player;
	}
	
	/**
	 * this method creates random enemies
	 * @return
	 */
	public Enemy[] createEnemies() {
		
		Random rnd = new Random();
		enemies = new Enemy[rnd.nextInt(5)];
		return enemies;
	}
	
	/**
	 * This method creates random objects
	 * @return
	 */
	public Object[] createObjects() {
		Random rnd = new Random();
		objects = new Object[rnd.nextInt(7)];
		return objects;
	}
}
