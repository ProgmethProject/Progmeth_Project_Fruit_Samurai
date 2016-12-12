package thread;

import java.util.ArrayList;
import java.util.List;

import Utility.InputUtility;
import graphic.PlayerStatus;
import javafx.application.Platform;
import logic.entity.ItemStatus;
import logic.generator.Generator;
import logic.highscore.HighScoreUtility;
import main.Main;

public class ThreadHolder {
	public static ThreadHolder instance = new ThreadHolder();
	private Thread gameThread;
	private List<Generator> generators;

	private ThreadHolder() {
		generators = new ArrayList<>();
		resetThread();
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public Thread resetThread() {
		clearAllThread();
		gameThread = new Thread(() -> {
			Main.instance.getGameLogic().initGame();
			Main.instance.getGameLogic().startGame();
			while (true) {
				if (PlayerStatus.instance.isGameOver()) {
					Platform.runLater(() -> {
						HighScoreUtility.recordHighScore(PlayerStatus.instance.getScore());
					});
					PlayerStatus.instance.setGameOver(false);

					return;
				}
				try {
					Main.instance.getGameLogic().updateLogic();
					ItemStatus.instance.update();
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		});
		return gameThread;
	}

	public void clearAllThread() {
		if (gameThread != null) {
			gameThread.interrupt();
		}
		for (Generator generator : generators) {
			generator.stop();
		}
		System.out.println(generators.size());
	}

	public void addGenerator(Generator generator) {
		generators.add(generator);
	}
}
