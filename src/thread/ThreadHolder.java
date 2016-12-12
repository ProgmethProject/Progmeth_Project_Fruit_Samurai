package thread;

import java.util.ArrayList;
import java.util.List;

import graphic.PlayerStatus;
import javafx.application.Platform;
import logic.generator.Generator;
import logic.highscore.HighScoreUtility;
import main.Main;

public class ThreadHolder {
	public static ThreadHolder instance = new ThreadHolder();
	private Thread gameThread;
	private List<Generator> bombGenerators;
	private List<Generator> fruitGenerators;

	private ThreadHolder() {
		resetGameThread();
		bombGenerators = new ArrayList<>();
		fruitGenerators = new ArrayList<>();
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public Thread resetGameThread() {
		gameThread = new Thread(() -> {
			Main.instance.getGameLogic().initGame();
			Main.instance.getGameScreen().initRenderable();
			while (true) {
				// TODO Add GameOver transition
				if (PlayerStatus.instance.isGameOver()) {
					Platform.runLater(() -> {
						HighScoreUtility.recordHighScore(PlayerStatus.instance.getScore());
					});
					PlayerStatus.instance.setGameOver(false);
					return;
				}
				try {
					Main.instance.getGameLogic().updateLogic();
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		});
		return gameThread;
	}
}
