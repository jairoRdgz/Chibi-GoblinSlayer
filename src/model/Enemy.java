package model;

public class Enemy extends Character{
	public static final short GOBLIN = 1;
	public static final short CHAMPION = 2;
	public static final short LORD = 3;
	
	private int type;
	private double posx;
	private double posy;
	private double width;
	private double heigth;
	private int lives;
	
	public Enemy(int t, double x, double y, double w, double h) {
		super(x,y,w,h);
		type = t;
		lives(t);
	}
	
	private void lives(int types) {
		if(types == GOBLIN) {
			lives = 3;
		}else if (types == CHAMPION) {
			lives = 6;
		}else if(types == LORD) {
			lives = 15;
		}else {
			lives = 3;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(short lives) {
		this.lives = lives;
	}
	
	public double moveX(int movement) {
		if(movement == 3) {
			//Left
			setPosx(getPosx()-10);
		}else {
			//Right
			setPosx(getPosx()+10);
		}
		return getPosx();
	}
	
	public double moveY(int movement) {
		if(movement == 1) {
			//Up
			setPosy(getPosy()-10);
		}else if(movement == 2) {
			//Down
			setPosy(getPosy()+10);
		}
		return getPosy();
	}
	
	public boolean isAlive() {
		boolean alive = true;
		if(lives<=0) {
			alive = false;
		}
		return alive;
	}
	
}
