package logic;

import java.util.ArrayList;

import Utility.DrawingUtility;
import Utility.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import model.IRenderable;

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
	
	public void update() {
		if(InputUtility.isMouseLeftDown()) {
			if(Trail.instance.getTrailX().size() < 15) {
				Trail.instance.addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
			}
			else {
//				if(!Trail.instance.getTrailX().isEmpty()) {
					Trail.instance.getTrailX().remove(0);
					Trail.instance.getTrailY().remove(0);
					Trail.instance.addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
//				}
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
		if(!Trail.instance.getTrailX().isEmpty()) {
			DrawingUtility.drawTrail(gc);
		}
	}

}
