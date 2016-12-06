package gui;

import Utility.DrawingUtility;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import Utility.InputUtility;
import model.Background;
import model.Fruit;
import model.IRenderable;
import model.MenuButton;
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
		
		RenderableHolder.instance.addEntity(Background.instance);
		RenderableHolder.instance.addEntity(PlayerStatus.instance);
		RenderableHolder.instance.addEntity(MenuButton.instance);
		Fruit fruit = new Fruit(150, 150, 10, 20);
		System.out.println(fruit.getZ());
		RenderableHolder.instance.addEntity(fruit);
		//DrawingUtility.drawBackground(gc);
//		DrawingUtility.drawFruit(gc, 150, 150);
		paintComponents();
		addListener();
	}
	
	
	public void paintComponents(){
		for(IRenderable entity : RenderableHolder.instance.getEntities()) {
			if(!entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
	
	private void addListener() {
		canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("MouseReleased : " + event.getButton().toString());
				if (event.getButton() == MouseButton.PRIMARY)
					InputUtility.setMouseLeftDown(false);

			}
		});
		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("MousePressed : " + event.getButton().toString());
				if (event.getButton() == MouseButton.PRIMARY) {
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftLastDown(true);
				}

			}
		});

		canvas.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InputUtility.setMouseOnScreen(false);
			}
		});

		canvas.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InputUtility.setMouseOnScreen(true);
			}
		});

		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX((int) event.getX());
					InputUtility.setMouseY((int) event.getY());
				}
			}
		});

		canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX((int) event.getX());
					InputUtility.setMouseY((int) event.getY());
				}
			}
		});
	}
}
