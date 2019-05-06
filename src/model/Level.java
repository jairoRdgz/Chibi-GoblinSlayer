package model;

public class Level {
	private Player player;
	private Enemy[] enemys;
	private Object[] objects;
	
	public Level() {
		
	}

	public Player getPlayer() {
		return player;
	}

	public Enemy[] getEnemys() {
		return enemys;
	}

	public Object[] getObjects() {
		return objects;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEnemys(Enemy[] enemys) {
		this.enemys = enemys;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	
	
}
