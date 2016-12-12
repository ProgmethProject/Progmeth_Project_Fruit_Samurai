package logic.entity;

import java.util.ArrayList;

import Utility.InputUtility;
import graphic.PlayerStatus;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.IRenderable;

public class Trail implements IRenderable {
	private static int trailColor;
	private static ArrayList<Integer> trailX = new ArrayList<Integer>();
	private static ArrayList<Integer> trailY = new ArrayList<Integer>();
	public static final Trail instance = new Trail();

	public ArrayList<Integer> getTrailX() {
		return trailX;
	}

	public ArrayList<Integer> getTrailY() {
		return trailY;
	}

	public void addTrail(int x, int y) {
		if (!PlayerStatus.instance.isPause()) {
			trailX.add(x);
			trailY.add(y);
		}
	}

	public void clearTrail() {
		trailX.clear();
		trailY.clear();
	}

	public void update() {
		if (InputUtility.isMouseLeftDown()) {
			if (getTrailX().size() < 10) {
				addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
			} else {
				getTrailX().remove(0);
				getTrailY().remove(0);
				addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
			}
		} else {
			if (!trailX.isEmpty()) {
				if ((int) trailX.get(0) == (int) trailX.get(trailX.size() - 1)) {
					trailX.clear();
					trailY.clear();
				} else if (getTrailX().size() < 10) {
					addTrail(InputUtility.getReleaseX(), InputUtility.getReleaseY());
				} else {
					getTrailX().remove(0);
					getTrailY().remove(0);
					addTrail(InputUtility.getReleaseX(), InputUtility.getReleaseY());
				}
			}
		}
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE - 1;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		update();
		if (!Trail.instance.getTrailX().isEmpty()) {
			double lineWidth = 20;
			ArrayList<Integer> trailX = Trail.instance.getTrailX();
			ArrayList<Integer> trailY = Trail.instance.getTrailY();
			int prevX = trailX.get(trailX.size() - 1);
			int prevY = trailY.get(trailY.size() - 1);

			for (int i = trailX.size() - 2; i >= 0; i--) {
				gc.setStroke(Color.DARKMAGENTA);
				gc.setLineWidth(lineWidth);
				gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
				gc.setStroke(Color.BLACK);
				gc.setLineWidth(lineWidth - 4);
				gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
				prevX = trailX.get(i);
				prevY = trailY.get(i);
				lineWidth -= 2;

			}
		}
	}

}
