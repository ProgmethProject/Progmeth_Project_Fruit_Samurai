package logic.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Utility.AudioUtility;
import Utility.DrawingUtility;
import Utility.InputUtility;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Main;

public class Fruit extends Entity implements Cuttable {
	private int point;
	protected int index;
	private int comboCount;

	public Fruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = random.nextInt(7);
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
		DrawingUtility.drawFruit(gc, index, rotation, x, y);
	}

	@Override
	public void cut() {
		PlayerStatus.instance.increaseComboCount(1);
		PlayerStatus.instance.increaseScore(point);
		comboCount = PlayerStatus.instance.getComboCount();

		Image image = DrawingUtility.getFruit(index);
		setDestroyed(true);
		synchronized (RenderableHolder.instance.getEntities()) {
			RenderableHolder.instance.getEntities().add(DrawingUtility.createCuttingAnimation(
					(int) (x + image.getWidth() / 2), (int) (y + image.getHeight() / 2), comboCount));
		}
		HalfFruit left = new HalfFruit(x, y, -speedX, speedY, rotation, index, 0);
		HalfFruit right = new HalfFruit(x, y, speedX, speedY, rotation, index, 1);
		Main.instance.getGameLogic().addEntity(left);
		Main.instance.getGameLogic().addEntity(right);
		AudioUtility.playSound("slash");
	}

	@Override
	public boolean isCut() {
		Image image = DrawingUtility.getFruit(index);

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

		Double tempX = prevX;
		Double tempY = prevY;

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
