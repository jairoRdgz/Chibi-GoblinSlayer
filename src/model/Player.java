package model;

public class Player {
	
	private double posX;
	private double posY;
	private double layoutX;
	private double layoutY;
	
	public Player(double pX, double pY, double lX, double lY) {
		this.posX = pX;
		this.posY = pY;
		this.layoutX = lX;
		this.layoutY = lY;
		
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
