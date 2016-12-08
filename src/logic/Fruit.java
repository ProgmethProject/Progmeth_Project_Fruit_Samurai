package logic;





import java.util.Random;

import com.sun.javafx.geom.transform.BaseTransform;

import Utility.DrawingUtility;
import Utility.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import model.Cuttable;
import model.Entity;

public class Fruit extends Entity implements Cuttable{

	private int index;	
	
	public Fruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = random.nextInt(DrawingUtility.fruit.length);
	}

	
	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = DrawingUtility.fruit[index];
		
		DrawingUtility.drawRotatedImage(gc, image, rotation, x, y);
	}


	@Override
	public void cut() {
//		if(InputUtility.)
	}


	@Override
	public Shape initHitBox() {
		return new Rectangle(x, y, 50, 50);
	}

}
