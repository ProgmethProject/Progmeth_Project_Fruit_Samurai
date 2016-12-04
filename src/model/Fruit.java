package model;

public class Fruit extends Entity{

	int point;
	
	public Fruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
	}

	
	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void draw() {
		
	}

}
