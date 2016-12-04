
public class Fruit extends Entity{

	int point;
	
	public Fruit(double x, double y, double speedX, double speedY, int z) {
		super(x, y, speedX, speedY, z);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void draw() {
		
	}

	@Override
	public int compareTo(IRenderable o) {
		return 0;
	}

}
