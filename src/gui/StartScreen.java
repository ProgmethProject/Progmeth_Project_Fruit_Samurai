package gui;


import Utility.DrawingUtility;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;
import sun.security.krb5.Config;

public class StartScreen extends BorderPane {
	private StackPane titlePane;
	private MenuPane menuPane;

	public StartScreen() {
		titlePane = new StackPane();
		titlePane.setPrefHeight(80);
		titlePane.setAlignment(Pos.CENTER);
		
		Label label = new Label("Fruit Samurai");
		label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
		label.setTextFill(Color.CADETBLUE);
				
		titlePane.getChildren().add(label);

		menuPane = new MenuPane();

//		setTop(titlePane);
		setCenter(menuPane);
	}

	public static class MenuPane extends GridPane {
		
		private Button startButton, collectionButton, settingButton, exitButton;
		private StackPane startPane, collectionPane, settingPane, exitPane;

		public MenuPane() {

			setAlignment(Pos.CENTER);
			
			String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
			this.setStyle("-fx-background-image: url('" + image + "'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;");
			
			startButton = new Button("Start");
			collectionButton = new Button("Collections");
			settingButton = new Button("Setting");
			exitButton = new Button("Exit");
			
			startButton.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
					+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
					+ "-fx-text-fill: black; -fx-font-size: 40px;"
					+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
					+ "-fx-border-color: black; -fx-border-width: 5;"
					+ "-fx-opacity:1;");
			
			collectionButton.setStyle("-fx-background-color:dodgerblue; -fx-background-radius: 0,0,0,0; "
					+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
					+ "-fx-text-fill: black; -fx-font-size: 40px;"
					+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
					+ "-fx-border-color: black; -fx-border-width: 5;");
			
			settingButton.setStyle("-fx-background-color:limegreen; -fx-background-radius: 0,0,0,0; "
					+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
					+ "-fx-text-fill: black; -fx-font-size: 40px;"
					+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
					+ "-fx-border-color: black; -fx-border-width: 5;"
					+ "-fx-opacity:1;");
			
			exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
					+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
					+ "-fx-text-fill: black; -fx-font-size: 40px;"
					+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
					+ "-fx-border-color: black; -fx-border-width: 5;"); 

			startPane = new StackPane(startButton);
			collectionPane = new StackPane(collectionButton);
			settingPane = new StackPane(settingButton);
			exitPane = new StackPane(exitButton);
			
			GridPane.setVgrow(startPane, Priority.ALWAYS);
			GridPane.setVgrow(collectionPane, Priority.ALWAYS);
			GridPane.setVgrow(settingPane, Priority.ALWAYS);
			GridPane.setVgrow(exitPane, Priority.ALWAYS);
			
			add(startPane, 0, 0);
			add(collectionPane, 0, 1);
			add(settingPane, 0, 2);
			add(exitPane, 0, 3);
			
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
					screenTransition();
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
					screenTransition();
					PauseTransition pause = new PauseTransition(Duration.millis(700));
					pause.setOnFinished(event -> {
						Main.instance.changeToCollectionScreen();
					});
					pause.play();
					
				}

			});
			
			settingButton.setOnMouseEntered(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					settingButton.setStyle("-fx-background-color:lime; -fx-background-radius: 0,0,0,0; "
							+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
							+ "-fx-text-fill: black; -fx-font-size: 40px;"
							+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
							+ "-fx-border-color: black; -fx-border-width: 5;");
				}
			});
			
			settingButton.setOnMouseExited(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					settingButton.setStyle("-fx-background-color:limegreen; -fx-background-radius: 0,0,0,0; "
							+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
							+ "-fx-text-fill: black; -fx-font-size: 40px;"
							+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
							+ "-fx-border-color: black; -fx-border-width: 5;");
				}
			});

			settingButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					screenTransition();
					PauseTransition pause = new PauseTransition(Duration.millis(700));
					pause.setOnFinished(event -> {
						//TODO
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
		
		private void screenTransition() {
			TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
			startTrans.setByX(-ConfigurableSettings.screenWidth);
			TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
			collctionTrans.setByX(-ConfigurableSettings.screenWidth);
			TranslateTransition settingTrans = new TranslateTransition(Duration.millis(700), settingPane);
			settingTrans.setByX(-ConfigurableSettings.screenWidth);
			TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
			exitTrans.setByX(-ConfigurableSettings.screenWidth);
			startTrans.play();
			collctionTrans.play();
			settingTrans.play();
			exitTrans.play();
		}

	}
}
