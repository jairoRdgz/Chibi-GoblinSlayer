package model;
/**
 * This class is in contains all the position attributes from the characters.
 * This class is also the father class to the Enemy class and Player class.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class Character {
	protected double posx;
	protected double posy;
	protected double width;
	protected double heigth;
	/**
	 * Constructor methos from the class
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Character(double x, double y, double w, double h) {
		this.posx = x;
		this.posy = y;
		this.width = w;
		this.heigth = h;
	}

	/**
	 * gets the position in X
	 * @return
	 */
	public double getPosx() {
		return posx;
	}

	/**
	 * sets the position in X
	 * @param posx
	 */
	public void setPosx(double posx) {
		this.posx = posx;
	}

	/**
	 * gets the position in Y
	 * @return
	 */
	public double getPosy() {
		return posy;
	}

	/**
	 * Sets the position in Y
	 * @param posy
	 */
	public void setPosy(double posy) {
		this.posy = posy;
	}

	/**
	 * Gets the character width
	 * @return
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * sets the character width
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * gets the character height
	 * @return
	 */
	public double getHeigth() {
		return heigth;
	}

	/**
	 * sets the character height
	 * @param heigth
	 */
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	
	
}
