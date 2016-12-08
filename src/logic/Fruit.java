package logic;



import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Entity;

public class Fruit extends Entity{

	int point;
	
	public Fruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
	}

	
	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = DrawingUtility.fruit[1];
		gc.drawImage(image, x, y);
	}

}
