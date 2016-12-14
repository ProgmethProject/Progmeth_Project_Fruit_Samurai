/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import utility.DrawingUtility;

public class HalfFruit extends Entity {
	private int index;
	private int side;

	public HalfFruit(double x, double y, double speedX, double speedY, double rotation, int index, int side) {
		super(x, y, speedX, speedY);
		super.rotation = rotation;
		this.side = side;
		this.index = index;
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
		DrawingUtility.drawHalfFruit(gc, index, side, rotation, x, y);
	}

}
