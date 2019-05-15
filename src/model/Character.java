package model;

public class Character {
	protected double posx;
	protected double posy;
	protected double width;
	protected double heigth;
	
	public Character(double x, double y, double w, double h) {
		this.posx = x;
		this.posy = y;
		this.width = w;
		this.heigth = h;
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
	
	
}
