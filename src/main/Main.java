package main;

import graphic.RenderableHolder;
import gui.CollectionScreen;
import gui.ConfigurableSettings;
import gui.GameScreen;
import gui.StartScreen;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameLogic;

public class Main extends Application {

	public static Main instance;
	private Stage primaryStage;

	private CollectionScreen collectionScreen;
	private GameScreen gameScreen;
	private StartScreen startScreen;

	private GameLogic gameLogic;
	private Thread gameThread;

	Scene collectionScene, gameScene, startScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
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

		this.gameScene = new Scene(gameScreen, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);
		this.collectionScene = new Scene(collectionScreen, ConfigurableSettings.screenWidth,
				ConfigurableSettings.screenHeight);
		this.startScene = new Scene(startScreen, ConfigurableSettings.screenWidth, ConfigurableSettings.screenHeight);

		this.primaryStage.setScene(this.startScene);
		this.primaryStage.show();

		this.gameThread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(16);
				} catch (InterruptedException e) {
					return;
				}
				gameLogic.updateLogic();
				Main.instance.drawGameScreen();
			}
		});
	}

	public void changeToStartScreen() {
		this.primaryStage.setScene(startScene);
		this.gameThread.interrupt();
	}

	public void changeToGameScreen() {
		this.primaryStage.setScene(gameScene);
		gameThread.start();
	}

	public void changeToCollectionScreen() {
		this.primaryStage.setScene(collectionScene);
		this.gameThread.interrupt();
	}

	public void closeScreen() {
		this.primaryStage.close();
		this.gameThread.interrupt();
	}

	public void drawGameScreen() {
		this.gameScreen.paintComponents();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
