package model;

public class Enemy extends Character{
	public static final short GOBLIN = 1;
	public static final short CHAMPION = 2;
	public static final short LORD = 3;
	
	private short type;
	private double posx;
	private double posy;
	private double width;
	private double heigth;
	private short lives;
	
	public Enemy(short t, double x, double y, double w, double h, short l) {
		super(x,y,w,h);
		type = t;
		lives(t);
	}
	
	private void lives(short types) {
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

	public short getType() {
		return type;
	}

	public void setType(short type) {
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

	public short getLives() {
		return lives;
	}

	public void setLives(short lives) {
		this.lives = lives;
	}
	
	
}
