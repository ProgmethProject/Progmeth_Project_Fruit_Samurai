package gui;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class ConfigurableSettings extends GridPane {
	public static double screenWidth = 1024,screenHeight = 768;
	public static int difficulty;
	public boolean mute;
	private Button resolution;
	
	public ConfigurableSettings() {
		
		setAlignment(Pos.CENTER);
		
		String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
		this.setStyle("-fx-background-image: url('" + image + "'); "
					 + "-fx-background-position: center center;"
		    	     + "-fx-background-repeat: stretch; -fx-background-size:" 
		    	     + ConfigurableSettings.screenWidth + " " + ConfigurableSettings.screenHeight
		    	     + ";");
		
		resolution = new Button("1024x768");
		resolution.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
				+ "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;"
				+ "-fx-opacity:1;");
		add(resolution, 0, 0);
		
	}
	public void transIn() {
		TranslateTransition resolutionTrans = new TranslateTransition(Duration.millis(700), resolution);
		resolutionTrans.setFromX(ConfigurableSettings.screenWidth*1);
		resolutionTrans.setByX(-ConfigurableSettings.screenWidth);
		resolutionTrans.play();
	}

}
