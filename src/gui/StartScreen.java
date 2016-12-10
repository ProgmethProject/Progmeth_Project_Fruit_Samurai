package gui;


import Utility.DrawingUtility;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;

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

		setTop(titlePane);
		setCenter(menuPane);
	}

	public static class MenuPane extends GridPane {
		
		private Button startButton, collectionButton, exitButton;
		private StackPane startPane, collectionPane, exitPane;

		public MenuPane() {

			setAlignment(Pos.CENTER);
			
			String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
			this.setStyle("-fx-background-image: url('" + image + "'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;");
			
			startButton = new Button("Start");
			collectionButton = new Button("Collections");
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
					+ "-fx-border-color: black; -fx-border-width: 5;"
					+ "-fx-opacity:1;");
			
			exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
					+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
					+ "-fx-text-fill: black; -fx-font-size: 40px;"
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
					Main.instance.changeToGameScreen();
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
				public void handle(ActionEvent event) {
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

	}
}
