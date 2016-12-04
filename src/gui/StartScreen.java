package gui;

import javafx.geometry.Pos;
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
}
