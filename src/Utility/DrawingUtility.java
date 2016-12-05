package Utility;

import gui.ConfigurableSettings;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.RenderableHolder;

public class DrawingUtility {
	public static Image background;
	private static Image playButton;
	private static Image pauseButton;
	private static Image[] cross;
	private static Image[] fruit;
	
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
//		playButton = new Image(ClassLoader.getSystemResource("image/play_button.png").toString(), 50, 50, false, true);
//		pauseButton = new Image(ClassLoader.getSystemResource("image/pause_button.png").toString(), 50, 50, false, true);
	}
	
	public static void drawBackground(GraphicsContext gc) {
		gc.drawImage(background, 0, 0, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
		
	}
	
	public static void drawPlayButton(GraphicsContext gc, int size) {
		gc.drawImage(playButton, 10, 10, size, size);
	}
	
	public static void drawPauseButton(GraphicsContext gc, int size) {
		gc.drawImage(pauseButton, 10, 10, size, size);
	}

}
