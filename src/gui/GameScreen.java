package gui;

import Utility.InputUtility;
import graphic.IRenderable;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameScreen extends GridPane {

	private double screen_width, screen_height;
	private Canvas canvas;
	private GraphicsContext gc;

	public GameScreen() {

		screen_width = ScreenProperties.screenWidth;
		screen_height = ScreenProperties.screenHeight;
		canvas = new Canvas(screen_width, screen_height);
		gc = canvas.getGraphicsContext2D();
		this.getChildren().add(canvas);
		addListener();
	}

	public void paintComponents() {
		synchronized (RenderableHolder.instance.getEntities()) {
			for (IRenderable entity : RenderableHolder.instance.getEntities()) {
				if (!entity.isDestroyed()) {
					entity.draw(gc);
				}
			}
		}
	}

	private void addListener() {

		canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					InputUtility.setMouseLeftDown(false);
					if (!PlayerStatus.instance.isPause()) {
						InputUtility.setReleaseX(event.getX());
						InputUtility.setReleaseY(event.getY());
					}
				}
			}
		});
		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseX(event.getX());
					InputUtility.setMouseY(event.getY());
					logic.entity.Trail.instance.addTrail(event.getX(), event.getY());

				}
				if (InputUtility.getMouseX() >= 10 && InputUtility.getMouseX() <= 60 && InputUtility.getMouseY() >= 10
						&& InputUtility.getMouseY() <= 60) {
					PlayerStatus.instance.setPause(!PlayerStatus.instance.isPause());
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
				InputUtility.setMouseX(event.getX());
				InputUtility.setMouseY(event.getY());
			}
		});

		canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InputUtility.setMouseX(event.getX());
				InputUtility.setMouseY(event.getY());
			}
		});

	}
}
