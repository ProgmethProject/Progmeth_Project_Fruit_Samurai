package main;

import Utility.DrawingUtility;
import gui.CollectionScreen;
import gui.GameScreen;
import gui.ScreenProperties;
import gui.StartScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameLogic;
import thread.ThreadHolder;

public class Main extends Application {

	public static Main instance;
	private Stage primaryStage;

	private CollectionScreen collectionScreen;
	private GameScreen gameScreen;
	private StartScreen startScreen;
	private GameLogic gameLogic;
	private AnimationTimer drawingAnimation;

	private Scene collectionScene, gameScene, startScene, configScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		DrawingUtility.loadResource();
		instance = this;
		this.gameLogic = new GameLogic();

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Fruit Samurai");
		this.primaryStage.setResizable(false);
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});

		this.gameScreen = new GameScreen();
		this.collectionScreen = new CollectionScreen();
		this.startScreen = new StartScreen();

		this.gameScene = new Scene(gameScreen, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
		this.collectionScene = new Scene(collectionScreen, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
		this.startScene = new Scene(startScreen, ScreenProperties.screenWidth, ScreenProperties.screenHeight);

		this.drawingAnimation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				drawGameScreen();
			}
		};

		this.primaryStage.setScene(this.startScene);
		this.primaryStage.show();

	}

	public GameLogic getGameLogic() {
		return this.gameLogic;
	}

	public CollectionScreen getCollectionScreen() {
		return collectionScreen;
	}

	public StartScreen getStartScreen() {
		return startScreen;
	}

	public AnimationTimer getDrawingAnimation() {
		return drawingAnimation;
	}

	public GameScreen getGameScreen() {
		return this.gameScreen;
	}

	public void changeToStartScreen() {
		this.primaryStage.setScene(startScene);
		ThreadHolder.instance.getGameThread().interrupt();
		this.drawingAnimation.stop();
	}

	public void changeToGameScreen() {
		this.primaryStage.setScene(gameScene);
		gameLogic.initGame();
		ThreadHolder.instance.resetThread();
		ThreadHolder.instance.startAll();
		drawingAnimation.start();
	}

	public void changeToCollectionScreen() {
		this.primaryStage.setScene(collectionScene);
		ThreadHolder.instance.getGameThread().interrupt();
		this.drawingAnimation.stop();
	}

	public void closeScreen() {
		this.primaryStage.close();
		ThreadHolder.instance.getGameThread().interrupt();
		this.drawingAnimation.stop();
		ThreadHolder.instance.clearAllThread();
	}

	public void drawGameScreen() {
		this.gameScreen.paintComponents();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
