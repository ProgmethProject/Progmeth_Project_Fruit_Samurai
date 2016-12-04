
public abstract class TimedItem extends Entity implements Cuttable, IRenderable {
	protected int duration;
	
	public TimedItem(double x, double y, double speedX, double speedY, int z, int duration) {
		super(x, y, speedX, speedY);
		this.duration = duration;
	}

}
