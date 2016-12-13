package gui;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.Main;

public class StartScreen extends GridPane {
	private Button startButton, collectionButton, exitButton;
	private StackPane startPane, collectionPane, exitPane, titlePane;
	private Label titleLabel;

	public StartScreen() {

		setAlignment(Pos.CENTER);

		String image = ClassLoader.getSystemResource("image/background/menu.jpg").toString();
		this.setStyle("-fx-background-image: url('" + image + "'); " + "-fx-background-position: center center;"
				+ "-fx-background-repeat: stretch; -fx-background-size:" + ScreenProperties.screenWidth + " "
				+ ScreenProperties.screenHeight + "; -fx-background-radius: 0");

		titleLabel = new Label("Fruit Samurai");
		startButton = new Button("Start");
		collectionButton = new Button("Collections");
		exitButton = new Button("Exit");

		titleLabel.setStyle("-fx-font-size: 50px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
				+ "-fx-text-alignment:center; -fx-padding: 20; " + "-fx-background-color: white;"
				+ "-fx-border-color: black; -fx-border-width: 5;");

		setBtnColor(startButton, "darkorange");
		setBtnColor(collectionButton, "dodgerblue");
		setBtnColor(exitButton, "orchid");

		titlePane = new StackPane(titleLabel);
		startPane = new StackPane(startButton);
		collectionPane = new StackPane(collectionButton);
		exitPane = new StackPane(exitButton);

		GridPane.setVgrow(titlePane, Priority.ALWAYS);
		GridPane.setVgrow(startPane, Priority.ALWAYS);
		GridPane.setVgrow(collectionPane, Priority.ALWAYS);
		GridPane.setVgrow(exitPane, Priority.ALWAYS);

		add(titlePane, 0, 0);
		add(startPane, 0, 1);
		add(collectionPane, 0, 2);
		add(exitPane, 0, 3);

		addListener();

	}

	public void addListener() {
		titleLabel.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				randomTitleColor();
			}
		});

		titleLabel.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				randomTitleColor();
			}
		});

		titleLabel.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				randomTitleColor();
			}
		});

		startButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(startButton, "orange");
			}
		});

		startButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(startButton, "darkorange");
			}
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.changeToGameScreen();
				});
				pause.play();
			}

		});

		collectionButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(collectionButton, "deepskyblue");
			}
		});

		collectionButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(collectionButton, "dodgerblue");
			}
		});

		collectionButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Main.instance.getCollectionScreen().screenTransitionIn();
				Main.instance.changeToCollectionScreen();
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
				setBtnColor(exitButton, "violet");
			}
		});

		exitButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(exitButton, "orchid");
			}
		});

	}

	public void setBtnColor(Button Btn, String color) {
		Btn.setStyle("-fx-background-color:" + color + "; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");
	}

	public void randomTitleColor() {
		int colorA = (int) (Math.random() * 255);
		int colorB = (int) (Math.random() * 255);
		int colorC = (int) (Math.random() * 255);
		String color = colorA + ", " + colorB + ", " + colorC;
		titleLabel.setStyle("-fx-font-size: 50px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
				+ "-fx-text-alignment:center; -fx-padding: 20; " + "-fx-background-color: rgb(" + color + ");"
				+ "-fx-border-color: black; -fx-border-width: 5;");
	}

	public void screenTransitionOut() {
		TranslateTransition titleTrans = new TranslateTransition(Duration.millis(700), titlePane);
		titleTrans.setFromX(0);
		titleTrans.setToX(-ScreenProperties.screenWidth);
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setFromX(0);
		startTrans.setToX(-ScreenProperties.screenWidth);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setFromX(0);
		collctionTrans.setToX(-ScreenProperties.screenWidth);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setFromX(0);
		exitTrans.setToX(-ScreenProperties.screenWidth);
		titleTrans.play();
		startTrans.play();
		collctionTrans.play();
		exitTrans.play();
	}

	public void screenTransitionIn() {
		TranslateTransition titleTrans = new TranslateTransition(Duration.millis(700), titlePane);
		titleTrans.setFromX(-ScreenProperties.screenWidth);
		titleTrans.setToX(0);
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setFromX(-ScreenProperties.screenWidth);
		startTrans.setToX(0);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setFromX(-ScreenProperties.screenWidth);
		collctionTrans.setToX(0);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setFromX(-ScreenProperties.screenWidth);
		exitTrans.setToX(0);
		titleTrans.play();
		startTrans.play();
		collctionTrans.play();
		exitTrans.play();
	}
}
