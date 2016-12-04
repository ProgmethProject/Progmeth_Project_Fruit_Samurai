package model;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	int getZ();

	boolean isVisible();

	void draw(GraphicsContext gc);
}
