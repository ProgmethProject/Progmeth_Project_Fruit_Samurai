package logic.entity;

import java.util.Random;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.javafx.geom.transform.BaseTransform;

import Utility.AudioUtility;
import Utility.DrawingUtility;
import Utility.InputUtility;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import main.Main;
import model.Cuttable;
import model.Entity;
import sun.font.GlyphLayout.GVData;

public class Fruit extends Entity implements Cuttable {
	private int point;
	private int index;

	public Fruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = random.nextInt(DrawingUtility.fruit.length);
		point = 1;
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

	@Override
	public void cut() {
		PlayerStatus.instance.increaseScore(point);
		Image image = DrawingUtility.fruit[index];
		setDestroyed(true);
		synchronized (RenderableHolder.instance.getEntities()) {
			RenderableHolder.instance.getEntities().add(DrawingUtility
					.createCuttingAnimation((int) (x + image.getWidth() / 2), (int) (y + image.getHeight() / 2)));
		}
		HalfFruit left = new HalfFruit(x, y, -speedX, speedY, rotation, index, 0);
		HalfFruit right = new HalfFruit(x, y, speedX, speedY, rotation, index, 1);
		Main.instance.getGameLogic().addEntity(left);
		Main.instance.getGameLogic().addEntity(right);
		AudioUtility.playSound("slash");

	}

	@Override
	public boolean isCut() {
		Image image = DrawingUtility.fruit[index];

		int xx = (int) (x + image.getWidth() / 2);
		int yy = (int) (y + image.getHeight() / 2);

		int radius = (int) Math.max(image.getWidth() / 2, image.getHeight() / 2);

		int delX = (int) (InputUtility.getMouseX() - xx);
		int delY = (int) (InputUtility.getMouseY() - yy);

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
