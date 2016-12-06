package gui;

import Utility.DrawingUtility;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.IRenderable;
import model.PlayerStatus;
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
		this.getChildren().add(canvas);
		
		RenderableHolder.instance.addEntity(PlayerStatus.instance);
		DrawingUtility.drawBackground(gc);
		DrawingUtility.drawPauseButton(gc, 40);
		paintComponents();
	}
	
	
	public void paintComponents(){
		for(IRenderable entity : RenderableHolder.instance.getEntities()) {
			if(!entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
}
