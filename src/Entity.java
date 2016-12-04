
public abstract class Entity implements IRenderable {

	public static double GRAVITY = 9.8;

	protected double x, y, speedX, speedY;
	protected int z;
	protected boolean isDestroyed;

	

	public Entity(double x, double y, double speedX, double speedY, int z) {
		super();
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.z = z;
		isDestroyed = false;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	@Override
	public int compareTo(IRenderable o) {
		if (this.getZ() > o.getZ()) {
			return 1;
		} else if (this.getZ() == o.getZ()) {
			return 0;
		} else {
			return -1;
		}
	}

}
