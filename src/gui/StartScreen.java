package gui;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.Main;

public class StartScreen extends GridPane {
	private Button startButton, collectionButton, exitButton;
	private StackPane startPane, collectionPane, settingPane, exitPane;

	public StartScreen() {

		setAlignment(Pos.CENTER);

		String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
		this.setStyle("-fx-background-image: url('" + image + "'); "
					 + "-fx-background-position: center center;"
		    	     + "-fx-background-repeat: stretch; -fx-background-size:" 
		    	     + ScreenProperties.screenWidth + " " + ScreenProperties.screenHeight
		    	     + "; -fx-background-radius: 0");

		startButton = new Button("Start");
		collectionButton = new Button("Collections");
		exitButton = new Button("Exit");

		startButton.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		collectionButton.setStyle("-fx-background-color:dodgerblue; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		startPane = new StackPane(startButton);
		collectionPane = new StackPane(collectionButton);
		exitPane = new StackPane(exitButton);

		GridPane.setVgrow(startPane, Priority.ALWAYS);
		GridPane.setVgrow(collectionPane, Priority.ALWAYS);
		GridPane.setVgrow(exitPane, Priority.ALWAYS);

		add(startPane, 0, 0);
		add(collectionPane, 0, 1);
		add(exitPane, 0, 2);
		
		addListener();
	}

	public void addListener() {
		startButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				startButton.setStyle("-fx-background-color:orange; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		startButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				startButton.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.changeToGameScreen();
					screenTransitionIn();
				});
				pause.play();

			}

		});

		collectionButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				collectionButton.setStyle("-fx-background-color:deepskyblue; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		collectionButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				collectionButton.setStyle("-fx-background-color:dodgerblue; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		collectionButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.changeToCollectionScreen();
				});
				pause.play();

			}

		});

		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main.instance.closeScreen();
			}

		});

		exitButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				exitButton.setStyle("-fx-background-color:violet; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		exitButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

	}

	private void screenTransitionOut() {
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition settingTrans = new TranslateTransition(Duration.millis(700), settingPane);
		settingTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setByX(-ScreenProperties.screenWidth);
		startTrans.play();
		collctionTrans.play();
		settingTrans.play();
		exitTrans.play();
	}
	
	private void screenTransitionIn() {
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition settingTrans = new TranslateTransition(Duration.millis(700), settingPane);
		settingTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setByX(ScreenProperties.screenWidth);
		startTrans.play();
		collctionTrans.play();
		settingTrans.play();
		exitTrans.play();
	}
}
