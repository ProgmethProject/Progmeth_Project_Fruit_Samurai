package main;

import gui.CollectionScreen;
import gui.GameScreen;
import gui.StartScreen;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	Main instance;
	Stage primaryStage;
	
	CollectionScreen collectionScreen;
	GameScreen gameScreen;
	StartScreen startScreen;

	@Override
	public void start(Stage primaryStage) throws Exception {
		instance = this;
		BorderPane root = new BorderPane();
		
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
		
		root.setCenter(startScreen);
	}
	
	public void changeToStartScreen(){
		
	}
	
	public void changeToGameScreen(){
		
	}
	
	public void changeToCollectionScreen(){
		
	}

}
