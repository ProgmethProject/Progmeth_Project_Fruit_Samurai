package model;

import javafx.scene.canvas.GraphicsContext;

public interface Cuttable {
	void cut(GraphicsContext gc);
	boolean isCut();
}
