package gui;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.IRenderable;
import model.RenderableHolder;

public class GameScreen extends GridPane {
	private static double screen_width, screen_height;
	private static Canvas canvas;
	private static GraphicsContext gc;
	
	public GameScreen() {
		screen_width = ConfigurableSettings.screenWidth;
		screen_height = ConfigurableSettings.screenHeight;
		canvas = new Canvas(screen_width, screen_height);
		gc = canvas.getGraphicsContext2D();
		this.setAlignment(Pos.BOTTOM_RIGHT);
		this.getChildren().add(canvas);
		drawBackground();
		drawMenu();
	}
	
	public void drawMenu() {
		gc.setFill(Color.BLACK);
		gc.fillRoundRect(10, 10, 50, 50, 5, 5);
	}
	
	public void drawBackground() {
		gc.drawImage(RenderableHolder.instance.background, 0, 0, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
	}
	
	
	public void paintComponents(){
		for(IRenderable entity : RenderableHolder.instance.getEntities()) {
			if(!entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
}
