package logic.entity;

import java.util.ArrayList;
import java.util.List;

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
			RenderableHolder.instance.getEntities().add(DrawingUtility.createBombAnimation((int) x, (int) y));
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

		int xx = (int) (x + image.getWidth() / 2);
		int yy = (int) (y + image.getHeight() / 2);

		int radius = (int) Math.max(image.getWidth() / 2, image.getHeight() / 2);

		List<Double> xList = new ArrayList<>();
		List<Double> yList = new ArrayList<>();

		double prevX = InputUtility.getPrevMouseX();
		double prevY = InputUtility.getPrevMouseY();
		double curX = InputUtility.getMouseX();
		double curY = InputUtility.getMouseY();
		double scaleX = (curX - prevX) / 100;
		double scaleY = (curY - prevY) / 100;

		double tempX = prevX, tempY = prevY;

		for (int i = 0; i < 100; i++) {
			xList.add(tempX);
			yList.add(tempY);
			tempX += scaleX;
			tempY += scaleY;
		}

		for (int i = 0; i < 100; i++) {
			if (InputUtility.isMouseLeftDown()) {
				int delX = (int) (xList.get(i) - xx);
				int delY = (int) (yList.get(i) - yy);
				if (delX * delX + delY * delY <= radius * radius) {
					if (InputUtility.getMouseSpeed() > 10) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
