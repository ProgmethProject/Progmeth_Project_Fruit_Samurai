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
			if(getTrailX().size() < 10) {
				addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
			}
			else {
					getTrailX().remove(0);
					getTrailY().remove(0);
					addTrail(InputUtility.getMouseX(), InputUtility.getMouseY());
			}
		}
		else {
			if(!trailX.isEmpty()) {
				if((int)trailX.get(0)==(int)trailX.get(trailX.size() - 1)) {
					trailX.clear();
					trailY.clear();
				}
				else if(getTrailX().size() < 10) {
					addTrail(InputUtility.getReleaseX(), InputUtility.getReleaseY());
				}
				else {
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
		if(!Trail.instance.getTrailX().isEmpty()) {
			DrawingUtility.drawTrail(gc);
//			System.out.println(trailX);
		}
	}

}
