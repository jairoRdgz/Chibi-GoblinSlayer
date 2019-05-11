package model;

public class Player {
	
	private double posX;
	private double posY;
	private double width;
	private double height;
	private int lives;
	private int damage;
	
	public Player(double pX, double pY,double w, double h, int l, int d) {
		this.posX = pX;
		this.posY = pY;
		this.width = w;
		this.height = h;
		this.lives = l;
		this.damage = d;
		
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public int getLives() {
		return lives;
	}

	public int getDamage() {
		return damage;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
