package logic.entity;

import Utility.AudioUtility;
import Utility.DrawingUtility;
import Utility.InputUtility;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
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
		setDestroyed(true);
		synchronized (RenderableHolder.instance.getEntities()) {
			RenderableHolder.instance.getEntities().add(DrawingUtility
					.createBombAnimation((int) x, (int) y));
		}
		AudioUtility.playSound("bomb");
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
		Image image = DrawingUtility.bomb;
		// double radiusRotate = Math.sqrt(Math.pow(image.getWidth() / 2, 2) +
		// Math.pow(image.getHeight() / 2, 2));
		//
		// int xx = (int) (x + radiusRotate * Math.sin((45 + rotation) * Math.PI
		// / 180));
		// int yy = (int) (y + radiusRotate * Math.cos((45 + rotation) * Math.PI
		// / 180));

		int xx = (int) (x + image.getWidth() / 2);
		int yy = (int) (y + image.getHeight() / 2);

		int radius = (int) Math.max(image.getWidth() / 2, image.getHeight() / 2);

		int delX = (int) (InputUtility.getMouseX() - xx);
		int delY = (int) (InputUtility.getMouseY() - yy);

		// System.out.println(x + ":" + y + " rotation:" + rotation);
		if (InputUtility.isMouseLeftDown()) {
			if (delX * delX + delY * delY <= radius * radius) {
				if (InputUtility.getMouseSpeed() > 10) {
					System.out.println(
							InputUtility.getMouseSpeed() + "with angle" + InputUtility.getMouseAngle() * 180 / Math.PI);
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

}
