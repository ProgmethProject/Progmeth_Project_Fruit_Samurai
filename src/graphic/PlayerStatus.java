package graphic;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.IRenderable;

public class PlayerStatus implements IRenderable {
	private static final int DEFAULT_HP = 3; 
	private int score;
	private int scoreModifier;
	private int healthPoint;
	private boolean onCombo = false;
	private int comboCount = 0;
	private boolean pause = false;

	public static final PlayerStatus instance = new PlayerStatus(DEFAULT_HP);
	
	public PlayerStatus(int healthPoint) {
		this.healthPoint = healthPoint;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore(int score) {
		this.score += score*scoreModifier;
	}
	
	public void setScoreModifier(int scoreModifier) {
		this.scoreModifier = scoreModifier;
	}
	
	public int getHealthPoint() {
		return healthPoint;
	}

	public void adjustHealthPoint(int healthPoint) {
		this.healthPoint += healthPoint;
	}

	public boolean isOnCombo() {
		return onCombo;
	}

	public void setOnCombo(boolean onCombo) {
		this.onCombo = onCombo;
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
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
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
		DrawingUtility.drawPlayerStatus(gc);
	}

	

}
