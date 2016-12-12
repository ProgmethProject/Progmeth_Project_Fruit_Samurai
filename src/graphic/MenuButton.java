package graphic;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import model.IRenderable;

public class MenuButton implements IRenderable {
	private int buttonSize = 50;
	public static final MenuButton instance = new MenuButton();
	
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
		if(!PlayerStatus.instance.isPause()) {
			gc.drawImage(DrawingUtility.pauseButton, 10, 10, buttonSize, buttonSize);
		}
		else {
			gc.drawImage(DrawingUtility.playButton, 10, 10, buttonSize, buttonSize);
		}
	}

}
