package logic;

import java.util.Random;

import com.sun.corba.se.spi.orbutil.fsm.Input;
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
import sun.font.GlyphLayout.GVData;

public class Fruit extends Entity implements Cuttable {

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
		gc.fillRect(x + image.getWidth()/2, y + image.getHeight()/2, 5, 5);
	}

	@Override
	public void cut() {
		// if(InputUtility.)
		setDestroyed(true);
	}

	@Override
	public Shape initHitBox() {
		return new Rectangle(x, y, 50, 50);
	}

	@Override
	public boolean isCut() {
		// TODO Auto-generated method stub
		Image image = DrawingUtility.fruit[index];
//		double radiusRotate = Math.sqrt(Math.pow(image.getWidth() / 2, 2) + Math.pow(image.getHeight() / 2, 2));
//
//		int xx = (int) (x + radiusRotate * Math.sin((45 + rotation) * Math.PI / 180));
//		int yy = (int) (y + radiusRotate * Math.cos((45 + rotation) * Math.PI / 180));

		int xx = (int) (x + image.getWidth()/2);
		int yy = (int) (y + image.getHeight()/2);
		
		int radius = (int) Math.max(image.getWidth() / 2, image.getHeight() / 2);

		int delX = (int) (InputUtility.getMouseX() - xx);
		int delY = (int) (InputUtility.getMouseY() - yy);

//		System.out.println(x + ":" + y + "  rotation:" + rotation);
		if (delX * delX + delY * delY <= radius * radius) {
			System.out.println(true);
			return true;
		}

		return false;
	}

}
