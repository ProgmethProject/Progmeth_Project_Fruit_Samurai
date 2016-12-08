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
	public static Image bomb;
	
	static {
		loadResource();
	}
	
	public static void loadResource() {
		cross = new Image[2];
		cross[0] = new Image(ClassLoader.getSystemResource("image/black_cross.png").toString(), 50, 60, false, true);
		cross[1] = new Image(ClassLoader.getSystemResource("image/red_cross.png").toString(), 50, 60, false, true);
		fruit = new Image[10];
		fruit[0] = new Image(ClassLoader.getSystemResource("image/apple.png").toString(), 50, 60, false, true);
		fruit[1] = new Image(ClassLoader.getSystemResource("image/banana.png").toString(), 80, 50, false, true);
		fruit[2] = new Image(ClassLoader.getSystemResource("image/fig.png").toString(), 50, 60, false, true);
		fruit[3] = new Image(ClassLoader.getSystemResource("image/grapes.png").toString(), 65, 50, false, true);
		fruit[4] = new Image(ClassLoader.getSystemResource("image/mango.png").toString(), 70, 50, false, true);
		fruit[5] = new Image(ClassLoader.getSystemResource("image/orange.png").toString(), 50, 50, false, true);
		fruit[6] = new Image(ClassLoader.getSystemResource("image/peach.png").toString(), 55, 55, false, true);
		fruit[7] = new Image(ClassLoader.getSystemResource("image/pineapple.png").toString(), 50, 75, false, true);
		fruit[8] = new Image(ClassLoader.getSystemResource("image/raspberry.png").toString(), 50, 50, false, true);
		fruit[9] = new Image(ClassLoader.getSystemResource("image/strawberry.png").toString(), 45, 55, false, true);
		bomb = new Image(ClassLoader.getSystemResource("image/bomb.png").toString(), 50, 50, false, true);
		background = new Image(ClassLoader.getSystemResource("image/background.jpg").toString(), ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight, false, true);
		playButton = new Image(ClassLoader.getSystemResource("image/play_button.png").toString(), 50, 50, false, true);
		pauseButton = new Image(ClassLoader.getSystemResource("image/pause_button.png").toString(), 50, 50, false, true);
	}
	
	public static void drawBackground(GraphicsContext gc) {
		gc.drawImage(background, 0, 0, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
		
	}
	
	public static void drawPlayerStatus(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.setFont(Font.loadFont(ClassLoader.getSystemResource("fonts/ChineseTakeaway.ttf").toString(), 30));
		gc.fillText("SCORE: " + String.format("%03d", PlayerStatus.instance.getScore()), 70, 45);
		
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		double font_width = fontLoader.computeStringWidth("LIFE: ", gc.getFont());
		double font_height = fontLoader.getFontMetrics(gc.getFont()).getLineHeight();
		gc.fillText("LIFE:", 410, 45);
		drawLife(gc, 410 + font_width - 5, 45 - font_height + 3, PlayerStatus.instance.getHealthPoint());
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
	
	public static void drawMenuButton(GraphicsContext gc, boolean pause, double x, double y, int size) {
		if(!pause) {
			gc.drawImage(pauseButton, x, y, size, size);
		}
		else {
			gc.drawImage(playButton, x, y, size, size);
		}
	}
	
	public static void drawTrail(GraphicsContext gc) {
		int lineWidth = 10;
		ArrayList<Integer> trailX = Trail.instance.getTrailX();
		ArrayList<Integer> trailY = Trail.instance.getTrailY();
		int prevX = trailX.get(trailX.size() - 1);
		int prevY = trailY.get(trailY.size() - 1);
		
		for(int i = trailX.size() - 2; i>=0; i--) {
			gc.setLineWidth(lineWidth);
			gc.strokeLine(prevX, prevY, trailX.get(i), trailY.get(i));
			prevX = trailX.get(i);
			prevY = trailY.get(i);		
			lineWidth -= 0.1;
		}
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
