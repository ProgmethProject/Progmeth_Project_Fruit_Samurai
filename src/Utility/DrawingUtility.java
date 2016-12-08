package Utility;

import java.util.ArrayList;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import graphic.PlayerStatus;
import gui.ConfigurableSettings;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import logic.Trail;

public class DrawingUtility {
	public static Image background;
	public static Image playButton;
	public static Image pauseButton;
	public static Image[] cross;
	public static Image[] fruit;
	public static Image[] cut_fruit;
	public static Image bomb;
	public static Image cutanim;
	
	static {
		loadResource();
	}
	
	public static void loadResource() {
		cross = new Image[2];
		cross[0] = new Image(ClassLoader.getSystemResource("image/ui/black_cross.png").toString(), 50, 60, false, true);
		cross[1] = new Image(ClassLoader.getSystemResource("image/ui/red_cross.png").toString(), 50, 60, false, true);
		fruit = new Image[7];
		fruit[0] = new Image(ClassLoader.getSystemResource("image/entity/apple.png").toString(), 60, 50, false, true);
		fruit[1] = new Image(ClassLoader.getSystemResource("image/entity/grapes.png").toString(), 65, 50, false, true);
		fruit[2] = new Image(ClassLoader.getSystemResource("image/entity/mango.png").toString(), 70, 50, false, true);
		fruit[3] = new Image(ClassLoader.getSystemResource("image/entity/orange.png").toString(), 50, 50, false, true);
		fruit[4] = new Image(ClassLoader.getSystemResource("image/entity/peach.png").toString(), 55, 55, false, true);
		fruit[5] = new Image(ClassLoader.getSystemResource("image/entity/raspberry.png").toString(), 50, 50, false, true);
		fruit[6] = new Image(ClassLoader.getSystemResource("image/entity/strawberry.png").toString(), 45, 55, false, true);
		cut_fruit = new Image[14];
		cut_fruit[0] = new Image(ClassLoader.getSystemResource("image/cut_entity/apple1.png").toString(), 60, 50, false, true);
		cut_fruit[1] = new Image(ClassLoader.getSystemResource("image/cut_entity/apple2.png").toString(), 60, 50, false, true);
		cut_fruit[2] = new Image(ClassLoader.getSystemResource("image/cut_entity/grapes1.png").toString(), 65, 50, false, true);
		cut_fruit[3] = new Image(ClassLoader.getSystemResource("image/cut_entity/grapes2.png").toString(), 65, 60, false, true);
		cut_fruit[4] = new Image(ClassLoader.getSystemResource("image/cut_entity/mango1.png").toString(), 70, 50, false, true);
		cut_fruit[5] = new Image(ClassLoader.getSystemResource("image/cut_entity/mango2.png").toString(), 70, 50, false, true);
		cut_fruit[6] = new Image(ClassLoader.getSystemResource("image/cut_entity/orange1.png").toString(), 50, 50, false, true);
		cut_fruit[7] = new Image(ClassLoader.getSystemResource("image/cut_entity/orange2.png").toString(), 50, 50, false, true);
		cut_fruit[8] = new Image(ClassLoader.getSystemResource("image/cut_entity/peach1.png").toString(), 55, 55, false, true);
		cut_fruit[9] = new Image(ClassLoader.getSystemResource("image/cut_entity/peach2.png").toString(), 55, 55, false, true);
		cut_fruit[10] = new Image(ClassLoader.getSystemResource("image/cut_entity/raspberry1.png").toString(), 50, 50, false, true);
		cut_fruit[11] = new Image(ClassLoader.getSystemResource("image/cut_entity/raspberry2.png").toString(), 50, 50, false, true);
		cut_fruit[12] = new Image(ClassLoader.getSystemResource("image/cut_entity/strawberry1.png").toString(), 45, 55, false, true);
		cut_fruit[13] = new Image(ClassLoader.getSystemResource("image/cut_entity/strawberry2.png").toString(), 45, 55, false, true);
		cutanim = new Image(ClassLoader.getSystemResource("image/cutanim.png").toString(), 1040, 130, false, true);
		bomb = new Image(ClassLoader.getSystemResource("image/entity/bomb.png").toString(), 60, 65, false, true);
		background = new Image(ClassLoader.getSystemResource("image/background/background.jpg").toString(), ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight, false, true);
		playButton = new Image(ClassLoader.getSystemResource("image/ui/play_button.png").toString(), 50, 50, false, true);
		pauseButton = new Image(ClassLoader.getSystemResource("image/ui/pause_button.png").toString(), 50, 50, false, true);
	}
	
	public static void drawLife(GraphicsContext gc, double x, double y, int healthPoint) {
		int cross1, cross2, cross3;
		switch (healthPoint) {
			case 3: cross1 = 0;
					cross2 = 0;
					cross3 = 0;
					break;
			case 2: cross1 = 0;
					cross2 = 0;
					cross3 = 1;
					break;
			case 1: cross1 = 0;
					cross2 = 1;
					cross3 = 1;
					break;
			case 0: cross1 = 1;
					cross2 = 1;
					cross3 = 1;
					break;
			default:cross1 = 0;
					cross2 = 0;
					cross3 = 0;
					break;
		}
		gc.drawImage(cross[cross1], x, y, 30, 36);
		gc.drawImage(cross[cross2], x + 35, y, 30, 36);
		gc.drawImage(cross[cross3], x + 70, y, 30, 36);
	}
	
	public static void drawTrail(GraphicsContext gc) {
		double lineWidth = 10;
		ArrayList<Integer> trailX = Trail.instance.getTrailX();
		ArrayList<Integer> trailY = Trail.instance.getTrailY();
		int prevX = trailX.get(trailX.size() - 1);
		int prevY = trailY.get(trailY.size() - 1);
		
		for(int i = trailX.size() - 2; i>=0; i--) {
			gc.setLineWidth(lineWidth);
			gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
			prevX = trailX.get(i);
			prevY = trailY.get(i);		
			lineWidth -= 1;
		}
	}
	
	public static GameAnimation createCuttingAnimation(int x, int y) {
		GameAnimation anim = new GameAnimation(DrawingUtility.cutanim, 8, 1);
		anim.centerAnimationAt(x, y);
		anim.play();
		return anim;
	}
	
	public static void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    /**
     * Draws an image on a graphics context.
     *
     * The image is drawn at (tlpx, tlpy) rotated by angle pivoted around the point:
     *   (tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2)
     *
     * @param gc the graphics context the image is to be drawn on.
     * @param angle the angle of rotation.
     * @param tlpx the top left x co-ordinate where the image will be plotted (in canvas co-ordinates).
     * @param tlpy the top left y co-ordinate where the image will be plotted (in canvas co-ordinates).
     */
    public static void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }


}
