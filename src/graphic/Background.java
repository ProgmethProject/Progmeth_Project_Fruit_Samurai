package graphic;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.entity.IRenderable;

public class Background implements IRenderable {
	public static Background instance = new Background();

	@Override
	public int getZ() {
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		DrawingUtility.drawBackground(gc);
	}

}
