package model;

public abstract class InstantItem extends Entity implements Cuttable, IRenderable {

	public InstantItem(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
	}

}
