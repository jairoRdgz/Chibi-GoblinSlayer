package model;

public class Object {
	public static final short EXTRA_LIVE = 1;
	public static final short DAMAGE = 2;
	
	private short type;
	private double posX;
	private double posY;
	private double layoutX;
	private double layoutY;
	
	public Object(double pX, double pY, double lX, double lY, short t) {
		this.posX = pX;
		this.posY = pY;
		this.layoutX = lX;
		this.layoutY = lY;
		this.type = t;
	}
	
	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}


	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public double getLayoutX() {
		return layoutX;
	}

	public double getLayoutY() {
		return layoutY;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void setLayoutX(double layoutX) {
		this.layoutX = layoutX;
	}

	public void setLayoutY(double layoutY) {
		this.layoutY = layoutY;
	}
	
	
}
