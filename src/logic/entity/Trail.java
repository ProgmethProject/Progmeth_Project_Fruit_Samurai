package logic.entity;

import java.util.ArrayList;

import Utility.InputUtility;
import graphic.PlayerStatus;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Trail implements IRenderable {
	private static int slashColor = 1;
	private static Color trailColorIn = Color.BLACK;
	private static Color trailColorOut = Color.DARKMAGENTA;
	private static ArrayList<Integer> trailX = new ArrayList<Integer>();
	private static ArrayList<Integer> trailY = new ArrayList<Integer>();
	private static final Color[] rainbow = { Color.RED, Color.RED, Color.RED, Color.YELLOW, Color.YELLOW,
			Color.LIMEGREEN, Color.LIMEGREEN, Color.CYAN, Color.BLUE, Color.BLUE };
	public static final Trail instance = new Trail();

	public ArrayList<Integer> getTrailX() {
		return trailX;
	}

	public ArrayList<Integer> getTrailY() {
		return trailY;
	}

	public void addTrail(double d, double e) {
		if (!PlayerStatus.instance.isPause()) {
			trailX.add((int) d);
			trailY.add((int) e);
		}
	}

	public void clearTrail() {
		trailX.clear();
		trailY.clear();
	}

	public void setTrailColorIn(Color trailColorIn) {
		Trail.trailColorIn = trailColorIn;
	}

	public void setTrailColorOut(Color trailColorOut) {
		Trail.trailColorOut = trailColorOut;
	}

	public int getSlashColor() {
		return slashColor;
	}

	public void setSlashColor(int slashColor) {
		Trail.slashColor = slashColor;
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
				if (slashColor == 5) {
					trailColorOut = rainbow[i % 10];
					trailColorIn = rainbow[i % 10];
				}
				gc.setStroke(trailColorOut);
				gc.setLineWidth(lineWidth);
				gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
				gc.setStroke(trailColorIn);
				gc.setLineWidth(lineWidth - 4);
				gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
				prevX = trailX.get(i);
				prevY = trailY.get(i);
				lineWidth -= 2;

			}
		}
	}

}
