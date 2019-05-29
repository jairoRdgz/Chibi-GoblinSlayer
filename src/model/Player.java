package model;
/**
 * This class contains the attributes of the player
 * This class extends from the Character class
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 */
public class Player extends Character{
	
	public static final short DEFAULT_LIVES =3 ;
	public static final short DEFAULT_DAMAGE = 1;
	
	private double posx;
	private double posy;
	private double width;
	private double heigth;
	private short lives;
	private short damage;
	
	/**
	 * Constructor method
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Player(double x, double y, double w, double h) {
		super(x,y,w,h);
		this.lives = DEFAULT_LIVES;
		this.damage = DEFAULT_DAMAGE;
	}

	/**
	 * gets the position in X
	 */
	public double getPosx() {
		return posx;
	}

	/**
	 * sets the position in X
	 */
	public void setPosx(double posx) {
		this.posx = posx;
	}

	/**
	 * gets the position in Y
	 */
	public double getPosy() {
		return posy;
	}

	/**
	 * sets the position in Y
	 */
	public void setPosy(double posy) {
		this.posy = posy;
	}

	/**
	 * gets the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * sets the width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * gets the height
	 */
	public double getHeigth() {
		return heigth;
	}

	/**
	 * sets the height
	 */
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	/**
	 * gets the player lives
	 * @return
	 */
	public short getLives() {
		return lives;
	}

	/**
	 * sets the player lives
	 * @param lives
	 */
	public void setLives(short lives) {
		this.lives = lives;
	}

	/**
	 * gets the damage
	 * @return
	 */
	public short getDamage() {
		return damage;
	}

	/**
	 * sets the damage
	 * @param damage
	 */
	public void setDamage(short damage) {
		this.damage = damage;
	}
	
	/**
	 * This method contains the logic to move move the player in X
	 * @param movement
	 * @return
	 */
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
	
	/**
	 * This method contains the logic to move the player in Y
	 * @param movement
	 * @return
	 */
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
	
	/**
	 * This method contains the logic to recognize of the player bounce with another object in X
	 * @param movement
	 * @return
	 */
	public double bounceBackY(int movement) {
		if(movement == 1) {
			//if it was going UP
			setPosy(getPosy()+20);
		}else if(movement == 2) {
			//if it was going DOWN
			setPosy(getPosy()-20);
		}
		return getPosx();
	}
	
	/**
	 *  This method contains the logic to recognize of the player bounce with another object in Y
	 * @param movement
	 * @return
	 */
	public double bounceBackX(int movement) {
		if(movement == 3) {
			//if it was going LEFT
			setPosy(getPosx()+20);
		}else if(movement == 4) {
			//if it was going RIGHT
			setPosy(getPosx()-20);
		}
		return getPosy();
	}
}
