package model;

import java.util.ArrayList;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

public class Trail implements IRenderable {
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
		trailX.add(x);
		trailY.add(y);
	}
	
	public void clearTrail() {
		trailX.clear();
		trailY.clear();
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
		if(!Trail.instance.getTrailX().isEmpty()) {
			DrawingUtility.drawTrail(gc);
		}
	}

}
