
public abstract class timedItem extends Entity implements Cuttable, IRenderable {
	protected int duration;
	
	public timedItem(double x, double y, double speedX, double speedY, int z, int duration) {
		super(x, y, speedX, speedY, z);
		this.duration = duration;
	}

}
