package gui;

import Utility.DrawingUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class CollectionScreen extends BorderPane {
	private highScorePane highScorePane;
	private bladeSelectionPane bladeSelectionPane;
	
	public CollectionScreen() {
		String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
		this.setStyle("-fx-background-image: url('" + image + "'); "
					 + "-fx-background-position: center center;"
		    	     + "-fx-background-repeat: stretch; -fx-background-size:" 
		    	     + ScreenProperties.screenWidth + " " + ScreenProperties.screenHeight
		    	     + ";");
		
		highScorePane = new highScorePane();
		bladeSelectionPane = new bladeSelectionPane();
		
//		setLeft(highScorePane);
		setRight(bladeSelectionPane);
		
	}
	
	private class highScorePane {
		
	}
	
	private class bladeSelectionPane extends GridPane {
		private Button purpleBtn, blueBtn, greenBtn, redBtn, rainbowBtn;
		private Label selectColor;
		
		public  bladeSelectionPane() {
			setAlignment(Pos.CENTER);
			setPrefSize(ScreenProperties.screenWidth/2, ScreenProperties.screenHeight);
			setVgap(10);
			setHgap(10);
			setStyle("-fx-background-color: transparent; -fx-padding: 30");
			
			selectColor = new Label("Blade Color");
			selectColor.setPrefWidth(210);
			setLabel(selectColor, "mediumorchid");
			
			purpleBtn = new Button();
			blueBtn = new Button();
			greenBtn = new Button();
			redBtn = new Button();
			rainbowBtn = new Button();
			
			setBtn(purpleBtn, "mediumorchid");
			setBtn(blueBtn, "deepskyblue");
			setBtn(greenBtn, "limegreen");
			setBtn(redBtn, "red");
			setBtn(rainbowBtn, "gray");
			
			add(selectColor, 0, 0, 2, 1);
			add(purpleBtn, 0, 1);
			add(blueBtn, 1, 1);
			add(greenBtn, 0, 2);
			add(redBtn, 1, 2);
			add(rainbowBtn, 0, 3);
			
			addListener();
		}
		
		public void addListener() {
			purpleBtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "mediumorchid");
				}
			});
			
			blueBtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "deepskyblue");
				}
			});
			
			greenBtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "limegreen");
				}
			});

			redBtn.setOnAction(new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "red");
				}
			});
			
			rainbowBtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "gray");
				}
			});
			
		}
		
		public void setLabel(Label label, String color) {
			selectColor.setStyle("-fx-font-size: 30px; -fx-font-family:\"Arial Black\"; -fx-text-fill: " + color + ";"
					+ "-fx-text-alignment:center; -fx-background-color: white; -fx-padding: 0 5 0 5;"
					+ "-fx-border-color: black; -fx-border-width: 3;");
		}
		
		public void setBtn(Button Btn, String color) {
			Btn.setPrefSize(100, 100);
			Btn.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 0,0,0,0; "
					+ "-fx-background-size:50; -fx-border-color: black; -fx-border-width: 3;");
		}
	}
}
