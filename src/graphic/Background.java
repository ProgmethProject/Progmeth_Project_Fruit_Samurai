package graphic;

import Utility.DrawingUtility;
import gui.ConfigurableSettings;
import javafx.scene.canvas.GraphicsContext;
import model.IRenderable;

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
		gc.drawImage(DrawingUtility.background, 0, 0, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
	}
	
}
