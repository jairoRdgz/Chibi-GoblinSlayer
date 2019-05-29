package model;

/**
 * This class is in charge of the attributes from the enemies.
 * This class extends from the Character class
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
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
	/**
	 * class constructor
	 * @param t
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Enemy(int t, double x, double y, double w, double h) {
		super(x,y,w,h);
		type = t;
		lives(t);
	}
	/**
	 * This method works to know the amount of lives of the enemies according to their type
	 * @param types
	 */
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

	/**
	 * gets the enemy type
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * sets the enemy type
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Gets the enemy posotion in X
	 */
	public double getPosx() {
		return posx;
	}

	/**
	 * sets the enemy posotion in X
	 */
	public void setPosx(double posx) {
		this.posx = posx;
	}

	/**
	 * gets the enemy position in Y
	 */
	public double getPosy() {
		return posy;
	}

	/**
	 * sets the enemy position in Y
	 */
	public void setPosy(double posy) {
		this.posy = posy;
	}

	/**
	 * Gets the enemy width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * sets the enemy width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * gets the enemy height
	 */
	public double getHeigth() {
		return heigth;
	}

	/**
	 * sets the enemy height
	 */
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	/**
	 * gets the enemy lives
	 * @return
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * sets the enemy lives
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	/**
	 * This method contains the logic to moves the enemies
	 * @param movement
	 * @param max
	 * @param maxY
	 */
	public void moveGoblin(int movement, int max, int maxY) {
		if(movement == 1) {
			System.out.println("UP");
			//Up
			if(posy-10-heigth>0) {

				posy = posy-10;
			}else {
				movement = 2;
				posy = heigth;					
			}
		}else if(movement == 2) {
			System.out.println("DOWN");
			//Down
			if(posy+10+heigth<maxY) {

				posy = posy+10;
			}else {
				movement = 1;
				posy = max-heigth;					
			}
		}else if(movement == 3) {
			System.out.println("LEFT");
			//Left
			if(posx-10-width>0) {

				posx = posx-10;
			}else {
				movement = 4;
				posx = width;					
			}
		}else {
			System.out.println("RIGHT");
			//Right
			if(posx+10+width<max) {

				posx = posx+10;
			}else {
				movement = 3;
				posx = max-width;					
			}
		}
		
	}
	/**
	 * This method contains the logic to move the enemy on X
	 * @param movement
	 * @return
	 */
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
	
	/**
	 * This method contains the logic to move the enemy on Y
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
	 * This method works to know if the enemy is alive
	 * @return
	 */
	public boolean isAlive() {
		boolean alive = true;
		if(lives<=0) {
			alive = false;
		}
		return alive;
	}
	
}
