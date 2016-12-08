package logic;

import java.util.Random;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Entity;

public class HalfFruit extends Entity{
	private int index;

	public HalfFruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = random.nextInt(DrawingUtility.fruit.length);
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = DrawingUtility.fruit[index];

		DrawingUtility.drawRotatedImage(gc, image, rotation, x, y);
		gc.fillRect(x + image.getWidth() / 2, y + image.getHeight() / 2, 5, 5);
	}

}
