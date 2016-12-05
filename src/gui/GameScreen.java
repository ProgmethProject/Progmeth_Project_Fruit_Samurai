package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IRenderable;
import model.RenderableHolder;

public class GameScreen extends Canvas {
	public static int screen_width, screen_height;
	
	public GameScreen(int width,int height) {
		super(width, height);
		screen_width = width;
		screen_height = height;
		
	}
	
	public void paintComponents(){
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, screen_width, screen_height);
		for(IRenderable entity : RenderableHolder.instance.getEntities()) {
			if(!entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
}
