package model;
/**
 * This class contains the attributes from the objects 
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 */
public class Object {
	public static final short EXTRA_LIVE = 1;
	public static final short DAMAGE = 2;
	
	private short type;
	private double posX;
	private double posY;
	private double layoutX;
	private double layoutY;
	
	/**
	 * Constructor method
	 * @param pX
	 * @param pY
	 * @param lX
	 * @param lY
	 * @param t
	 */
	public Object(double pX, double pY, double lX, double lY, short t) {
		this.posX = pX;
		this.posY = pY;
		this.layoutX = lX;
		this.layoutY = lY;
		this.type = t;
	}
	
	/**
	 * gets the type
	 * @return
	 */
	public short getType() {
		return type;
	}

	/**
	 * sets the type
	 * @param type
	 */
	public void setType(short type) {
		this.type = type;
	}

	/**
	 * gets the position in X
	 * @return
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * gets the position in Y
	 * @return
	 */
	public double getPosY() {
		return posY;
	}

	/**
	 * gets the layout in X
	 * @return
	 */
	public double getLayoutX() {
		return layoutX;
	}

	/**
	 * gets the layout in Y
	 * @return
	 */
	public double getLayoutY() {
		return layoutY;
	}

	/**
	 * sets the position in X
	 * @param posX
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/**
	 * sets the position in Y
	 * @param posY
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}

	/**
	 * sets the layout in X
	 * @param layoutX
	 */
	public void setLayoutX(double layoutX) {
		this.layoutX = layoutX;
	}

	/**
	 * sets the layout in Y
	 * @param layoutY
	 */
	public void setLayoutY(double layoutY) {
		this.layoutY = layoutY;
	}
	
	
}
