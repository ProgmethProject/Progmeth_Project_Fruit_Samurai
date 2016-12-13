package graphic;

import javafx.scene.canvas.GraphicsContext;
import utility.DrawingUtility;

public class MenuButton implements IRenderable {
	private int buttonSize = 50;
	public static MenuButton instance = new MenuButton();

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (!PlayerStatus.instance.isPause()) {
			DrawingUtility.drawPauseButton(gc, buttonSize);
		} else {
			DrawingUtility.drawPlayButton(gc, buttonSize);
		}
	}
}
