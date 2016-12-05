package main;

import gui.CollectionScreen;
import gui.ConfigurableSettings;
import gui.GameScreen;
import gui.StartScreen;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	public static Main instance;
	private Stage primaryStage;
	
	private CollectionScreen collectionScreen;
	private GameScreen gameScreen;
	private StartScreen startScreen;
	
	Scene collectionScene, gameScene, startScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		instance = this;
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Fruit Samurai");
		this.primaryStage.setResizable(false);
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		
//		this.gameScreen = new GameScreen();
		this.collectionScreen = new CollectionScreen();
		this.startScreen = new StartScreen();
		

//		this.gameScene = new Scene(gameScreen,ConfigurableSettings.screenWidth,ConfigurableSettings.screenHeight);
		this.collectionScene = new Scene(collectionScreen,ConfigurableSettings.screenWidth,ConfigurableSettings.screenHeight);
		this.startScene = new Scene(startScreen,ConfigurableSettings.screenWidth,ConfigurableSettings.screenHeight);
		
		this.primaryStage.setScene(this.startScene);
		this.primaryStage.show();
	}
	
	public void changeToStartScreen(){
		this.primaryStage.setScene(startScene);
	}
	
	public void changeToGameScreen(){
		this.primaryStage.setScene(gameScene);
	}
	
	public void changeToCollectionScreen(){
		this.primaryStage.setScene(collectionScene);
	}
	
	public void closeScreen(){
		this.primaryStage.close();
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
