package model;

public class PlayerStatus implements IRenderable {
	private static final int DEFAULT_HP = 3; 
	private int score;
	private int scoreModifier;
	private int healthPoint;
	private boolean onCombo = false;
	private int comboCount = 0;
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

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void draw() {
		
	}


}
