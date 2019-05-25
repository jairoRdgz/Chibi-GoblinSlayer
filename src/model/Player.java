package model;

public class Player extends Character{
	
	public static final short DEFAULT_LIVES =3 ;
	public static final short DEFAULT_DAMAGE = 1;
	
	private double posx;
	private double posy;
	private double width;
	private double heigth;
	private short lives;
	private short damage;
	
	public Player(double x, double y, double w, double h) {
		super(x,y,w,h);
		this.lives = DEFAULT_LIVES;
		this.damage = DEFAULT_DAMAGE;
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

	public short getLives() {
		return lives;
	}

	public void setLives(short lives) {
		this.lives = lives;
	}

	public short getDamage() {
		return damage;
	}

	public void setDamage(short damage) {
		this.damage = damage;
	}
	
	public double moveX(int movement) {
		if(movement == 3) {
			//Left
			setPosx(getPosx()-10);
		}else {
			//Rigth
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
}
