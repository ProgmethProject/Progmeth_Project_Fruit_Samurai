
public class PlayerStatus implements IRenderable {
	private int score;
	private int scoreModifier;
	private int healthPoint;
	private boolean onCombo = false;
	private int comboCount = 0;
	
	public PlayerStatus(int healthPoint) {
		this.healthPoint = healthPoint;
		score = 0;
		onCombo = false;
		comboCount = 0;
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
		//TODO
	}


}
