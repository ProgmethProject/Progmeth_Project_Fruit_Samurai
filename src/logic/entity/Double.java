package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import model.Cuttable;
import model.IRenderable;
import model.TimedItem;

public class Double extends TimedItem implements IRenderable, Cuttable {

	public Double(double x, double y, double speedX, double speedY, int z, int duration) {
		super(x, y, speedX, speedY, z, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

}
