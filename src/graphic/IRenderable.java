package graphic;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	int getZ();

	boolean isDestroyed();

	void draw(GraphicsContext gc);
}
