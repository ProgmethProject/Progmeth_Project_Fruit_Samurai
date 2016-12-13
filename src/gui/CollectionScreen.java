package gui;

import Utility.HighScoreUtility;
import Utility.HighScoreUtility.HighScoreRecord;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import logic.entity.Trail;
import main.Main;

public class CollectionScreen extends BorderPane {
	private highScorePane highScorePane;
	private bladeSelectionPane bladeSelectionPane;
	private Button backButton;
	private StackPane backPane;

	public CollectionScreen() {
		String image = ClassLoader.getSystemResource("image/background/menu.jpg").toString();
		setStyle("-fx-background-image: url('" + image + "'); " + "-fx-background-position: center center;"
				+ "-fx-background-repeat: stretch; -fx-background-size:" + ScreenProperties.screenWidth + " "
				+ ScreenProperties.screenHeight + "; -fx-padding: 0");

		highScorePane = new highScorePane();
		bladeSelectionPane = new bladeSelectionPane();

		backPane = new StackPane();
		this.setPadding(new Insets(50));
		backButton = new Button("Back");
		setBtnColor(backButton, "dodgerblue");
		backPane.setStyle("-fx-background-color: transparent; -fx-padding: 30");
		backPane.setAlignment(Pos.CENTER);
		backPane.getChildren().add(backButton);

		setLeft(highScorePane);
		setRight(bladeSelectionPane);
		setBottom(backPane);
		
		addListener();

	}
	
	public void addListener() {
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.getStartScreen().screenTransitionIn();
					Main.instance.changeToStartScreen();
				});
				pause.play();

			}
		});
		
		backButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(backButton, "deepskyblue");
			}
		});

		backButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				setBtnColor(backButton, "dodgerblue");
			}
		});
	}
	
	public void setBtnColor(Button Btn, String color) {
		Btn.setStyle("-fx-background-color:" + color + "; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
				+ "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");
	}

	public void screenTransitionIn() {
		TranslateTransition highScoreTrans = new TranslateTransition(Duration.millis(700), highScorePane);
		highScoreTrans.setFromX(ScreenProperties.screenWidth);
		highScoreTrans.setToX(0);
		TranslateTransition selectionTrans = new TranslateTransition(Duration.millis(700), bladeSelectionPane);
		selectionTrans.setFromX(ScreenProperties.screenWidth);
		selectionTrans.setToX(0);
		TranslateTransition backTrans = new TranslateTransition(Duration.millis(700), backPane);
		backTrans.setFromX(ScreenProperties.screenWidth);
		backTrans.setToX(0);
		highScoreTrans.play();
		selectionTrans.play();
		backTrans.play();
		highScorePane.updatePane();
	}

	public void screenTransitionOut() {
		TranslateTransition highScoreTrans = new TranslateTransition(Duration.millis(700), highScorePane);
		highScoreTrans.setFromX(0);
		highScoreTrans.setToX(ScreenProperties.screenWidth);
		TranslateTransition selectionTrans = new TranslateTransition(Duration.millis(700), bladeSelectionPane);
		selectionTrans.setFromX(0);
		selectionTrans.setToX(ScreenProperties.screenWidth);
		TranslateTransition backTrans = new TranslateTransition(Duration.millis(700), backPane);
		backTrans.setFromX(0);
		backTrans.setToX(ScreenProperties.screenWidth);
		highScoreTrans.play();
		selectionTrans.play();
		backTrans.play();
	}
	
	
	

	public static class highScorePane extends GridPane {
		private Label[] labels = new Label[10];
		private Label highScoreHeader;

		public highScorePane() {
			setStyle("-fx-background-color: transparent; -fx-padding: 30");
			setPrefWidth(ScreenProperties.screenWidth / 2);
			setAlignment(Pos.CENTER);
			setVgap(5);

			StackPane labelPane = new StackPane();
			highScoreHeader = new Label("High Score");
			highScoreHeader.setStyle("-fx-font-size: 30px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
					+ "-fx-text-alignment:center; -fx-background-color: white; -fx-padding: 0 5 0 5;"
					+ "-fx-border-color: black; -fx-border-width: 3;");
			labelPane.getChildren().add(highScoreHeader);
			add(labelPane, 0, 0);

			GridPane scorePane = new GridPane();
			scorePane.setPrefSize(250, 300);
			scorePane.setStyle(
					"-fx-background-color: white; -fx-padding: 5;" + "-fx-border-color: black; -fx-border-width: 3;");
			scorePane.setAlignment(Pos.CENTER);

			for (int i = 0; i < 10; i++) {
				StackPane score = new StackPane();
				score.setStyle("-fx-background-color: transparent; -fx-padding: 5 13 5 13;"
						+ "-fx-font-size: 20px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;");
				labels[i] = new Label();
				labels[i].setAlignment(Pos.CENTER);
				score.getChildren().add(labels[i]);
				scorePane.add(score, 0, i);
			}
			add(scorePane, 0, 1);
			updatePane();
		}

		public void updatePane() {
			HighScoreRecord[] records = HighScoreUtility.loadTop10();
			if (records != null) {
				for (int i = 0; i < 10; i++) {
					labels[i].setText(records[i].getRecord());
				}
			}
		}
	}
	
	
	

	public static class bladeSelectionPane extends GridPane {
		private Button purpleBtn, blueBtn, greenBtn, redBtn, rainbowBtn;
		private Label selectColor;

		public bladeSelectionPane() {
			setAlignment(Pos.CENTER);
			setPrefWidth(ScreenProperties.screenWidth / 2);
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
			setBtn(rainbowBtn,
					"linear-gradient(from 0% 50% to 100% 50%, red 3%, orange 16%, yellow 30%, "
					+ "limegreen 44%, lightblue 64%, blue 77%, purple 92%)");

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
					Trail.instance.setSlashColor(1);
					Trail.instance.setTrailColorIn(Color.BLACK);
					Trail.instance.setTrailColorOut(Color.DARKMAGENTA);
				}
			});

			blueBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "deepskyblue");
					Trail.instance.setSlashColor(2);
					Trail.instance.setTrailColorIn(Color.DEEPSKYBLUE);
					Trail.instance.setTrailColorOut(Color.CYAN);
				}
			});

			greenBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "limegreen");
					Trail.instance.setSlashColor(3);
					Trail.instance.setTrailColorIn(Color.GREEN);
					Trail.instance.setTrailColorOut(Color.LIMEGREEN);
				}
			});

			redBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor, "red");
					Trail.instance.setSlashColor(4);
					Trail.instance.setTrailColorIn(Color.RED);
					Trail.instance.setTrailColorOut(Color.ORANGE);
				}
			});

			rainbowBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					setLabel(selectColor,
							"linear-gradient(from 0% 50% to 100% 50%, red 3%, orange 16%, yellow 30%, limegreen 44%, lightblue 64%, blue 77%, purple 92%)");
					Trail.instance.setSlashColor(5);
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
