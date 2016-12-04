package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class StartScreen extends BorderPane {
	StackPane titlePane;
	BorderPane menuPane;

	public StartScreen() {
		titlePane = new StackPane();
		titlePane.setPrefHeight(80);
		titlePane.setAlignment(Pos.CENTER);
	}

	public static class MenuPane extends BorderPane {
		private Button startButton, collectionButton, exitButton;

		public MenuPane() {
			
			startButton = new Button("Start");
			collectionButton = new Button("Collections");
			exitButton = new Button("Exit");
			
			startButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
				}
				
			});
			
			collectionButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
				}
				
			});
			
			exitButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
				}
				
			});
			
		}

	}
}
