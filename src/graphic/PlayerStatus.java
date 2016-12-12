package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import Utility.DrawingUtility;
import gui.ScreenProperties;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.IRenderable;

public class PlayerStatus implements IRenderable {
	public static final int DEFAULT_HP = 3;
	private int score;
	private int scoreModifier;
	private int healthPoint;
	private boolean isOnCombo = false;
	private int comboCount = 0;
	private boolean isPause = false;
	private boolean isGameOver = false;

	public static final PlayerStatus instance = new PlayerStatus(DEFAULT_HP);

	public PlayerStatus(int healthPoint) {
		initPlayer(healthPoint);
	}

	public void initPlayer(int healthPoint) {
		this.healthPoint = healthPoint;
		scoreModifier = 1;
		score = 0;
		isOnCombo = false;
		comboCount = 0;
		isPause = false;
		isGameOver = false;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore(int score) {
		this.score += score * scoreModifier;
	}

	public void setScoreModifier(int scoreModifier) {
		this.scoreModifier = scoreModifier;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public void adjustHealthPoint(int healthPoint) {
		this.healthPoint += healthPoint;
		if (this.healthPoint == 0) {
			this.isGameOver = true;
		}
	}

	public boolean isOnCombo() {
		return isOnCombo;
	}

	public void setOnCombo(boolean onCombo) {
		this.isOnCombo = onCombo;
	}

	public int getComboCount() {
		return comboCount;
	}

	public void increaseComboCount(int comboCount) {
		this.comboCount += comboCount;
	}

	public void resetComboCount() {
		this.comboCount = 0;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean pause) {
		this.isPause = pause;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.setFont(Font.loadFont(ClassLoader.getSystemResource("fonts/ChineseTakeaway.ttf").toString(), 30));
		gc.fillText("SCORE: " + String.format("%03d", PlayerStatus.instance.getScore()), 70, 45);

		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		double font_width = fontLoader.computeStringWidth("LIFE: ", gc.getFont());
		double font_height = fontLoader.getFontMetrics(gc.getFont()).getLineHeight();
		gc.fillText("LIFE:", 810, 45);
		DrawingUtility.drawLife(gc, 810 + font_width - 5, 45 - font_height + 3, PlayerStatus.instance.getHealthPoint());

		if (isPause) {
			gc.setGlobalAlpha(0.4);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
			gc.setGlobalAlpha(1.0);
			gc.setFill(Color.WHITE);
			gc.setFont(Font.loadFont(ClassLoader.getSystemResource("fonts/ChineseTakeaway.ttf").toString(), 50));
			gc.fillText("PAUSE", ScreenProperties.screenWidth / 2 - font_width, ScreenProperties.screenHeight / 2);
		}
	}

}
