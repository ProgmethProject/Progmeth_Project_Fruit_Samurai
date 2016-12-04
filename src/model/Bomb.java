package model;

import javafx.scene.canvas.GraphicsContext;

public class Bomb extends InstantItem {
	private int healthPointAdjustment = -1;
	
	public Bomb(double x, double y, double speedX, double speedY, int z) {
		super(x, y, speedX, speedY, z);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cut() {
		this.setDestroyed(true);
		PlayerStatus.instance.adjustHealthPoint(healthPointAdjustment);
		PlayerStatus.instance.resetComboCount();
		PlayerStatus.instance.setOnCombo(false);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
