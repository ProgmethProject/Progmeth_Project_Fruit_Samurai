package logic;

import Utility.DrawingUtility;
import graphic.PlayerStatus;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import model.InstantItem;

public class Bomb extends InstantItem {
	private int healthPointAdjustment = -1;

	public Bomb(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
	}

	@Override
	public void cut() {
		this.setDestroyed(true);
		PlayerStatus.instance.adjustHealthPoint(healthPointAdjustment);
		PlayerStatus.instance.resetComboCount();
		PlayerStatus.instance.setOnCombo(false);
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = DrawingUtility.bomb;

		DrawingUtility.drawRotatedImage(gc, image, rotation, x, y);
	}

	@Override
	public boolean isCut() {
		// TODO Auto-generated method stub
		return false;
	}

}
