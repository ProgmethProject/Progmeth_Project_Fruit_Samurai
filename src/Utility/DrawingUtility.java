package Utility;

import java.util.ArrayList;

import gui.ConfigurableSettings;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Trail;

public class DrawingUtility {
	public static Image background;
	private static Image playButton;
	public static Image pauseButton;
	public static Image[] cross;
	public static Image[] fruit;
	
	static {
		loadResource();
	}
	
	private static void loadResource() {
		cross = new Image[2];
		cross[0] = new Image(ClassLoader.getSystemResource("image/black_cross.png").toString(), 50, 50, false, true);
		cross[1] = new Image(ClassLoader.getSystemResource("image/red_cross.png").toString(), 50, 50, false, true);
		fruit = new Image[11];
		fruit[0] = new Image(ClassLoader.getSystemResource("image/apple.png").toString(), 50, 50, false, true);
		fruit[1] = new Image(ClassLoader.getSystemResource("image/banana.png").toString(), 50, 50, false, true);
		fruit[2] = new Image(ClassLoader.getSystemResource("image/blackberry.png").toString(), 50, 50, false, true);
		fruit[3] = new Image(ClassLoader.getSystemResource("image/fig.png").toString(), 50, 50, false, true);
		fruit[4] = new Image(ClassLoader.getSystemResource("image/grapes.png").toString(), 50, 50, false, true);
		fruit[5] = new Image(ClassLoader.getSystemResource("image/mango.png").toString(), 50, 50, false, true);
		fruit[6] = new Image(ClassLoader.getSystemResource("image/orange.png").toString(), 50, 50, false, true);
		fruit[7] = new Image(ClassLoader.getSystemResource("image/peach.png").toString(), 50, 50, false, true);
		fruit[8] = new Image(ClassLoader.getSystemResource("image/pineapple.png").toString(), 50, 50, false, true);
		fruit[9] = new Image(ClassLoader.getSystemResource("image/raspberry.png").toString(), 50, 50, false, true);
		fruit[10] = new Image(ClassLoader.getSystemResource("image/strawberry.png").toString(), 50, 50, false, true);
		background = new Image(ClassLoader.getSystemResource("image/background.jpg").toString(), ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight, false, true);
		playButton = new Image(ClassLoader.getSystemResource("image/play_button.png").toString(), 50, 50, false, true);
		pauseButton = new Image(ClassLoader.getSystemResource("image/pause_button.png").toString(), 50, 50, false, true);
	}
	
	public static void drawBackground(GraphicsContext gc) {
		gc.drawImage(background, 0, 0, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
		
	}
	
	public static void drawMenuButton(GraphicsContext gc, boolean pause, double x, double y, int size) {
		if(!pause) {
			gc.drawImage(pauseButton, x, y, size, size);
		}
		else {
			gc.drawImage(playButton, x, y, size, size);
		}
	}
	
	public static void drawFruit(GraphicsContext gc, double x, double y) {
		gc.drawImage(fruit[(int) (Math.random()*10)], x, y, 50, 50);
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

}
