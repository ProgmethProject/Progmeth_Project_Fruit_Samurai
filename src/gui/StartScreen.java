package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
			setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			
			startButton = new Button("Start");
			collectionButton = new Button("Collections");
			exitButton = new Button("Exit");


			startPane = new StackPane(startButton);
			collectionPane = new StackPane(collectionButton);
			exitPane = new StackPane(exitButton);
			
			GridPane.setVgrow(startPane, Priority.ALWAYS);
			GridPane.setVgrow(collectionPane, Priority.ALWAYS);
			GridPane.setVgrow(exitPane, Priority.ALWAYS);
			
			add(startPane, 0, 0);
			add(collectionPane, 0, 1);
			add(exitPane, 0, 2);

			startButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Main.instance.changeToGameScreen();
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

		}

	}
}
