package model;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;

public class Background implements IRenderable {
	public static Background instance = new Background();
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawBackground(gc);
	}
	
}
