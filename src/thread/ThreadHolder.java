package thread;

import java.util.ArrayList;
import java.util.List;

import Utility.InputUtility;
import graphic.PlayerStatus;
import javafx.application.Platform;
import logic.entity.ItemStatus;
import logic.generator.BombGenerator;
import logic.generator.FruitGenerator;
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
		gameThread = new GameThread();
		addGenerator(new FruitGenerator(Main.instance.getGameLogic(), 1500));
		addGenerator(new BombGenerator(Main.instance.getGameLogic(), 2000));
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
		generators.clear();
	}

	public void addGenerator(Generator generator) {
		generators.add(generator);
	}

	public void startAll() {
		gameThread.start();
		for (Generator generator : generators) {
			generator.start();
		}
	}
}
