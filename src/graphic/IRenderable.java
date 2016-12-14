/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package graphic;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	int getZ();

	boolean isDestroyed();

	void draw(GraphicsContext gc);
}
