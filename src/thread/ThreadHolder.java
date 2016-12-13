package thread;

import java.util.ArrayList;
import java.util.List;
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
		addGenerator(new FruitGenerator(1500));
		addGenerator(new BombGenerator(2000));
		return gameThread;
	}

	public void clearAllThread() {
		if (gameThread != null) {
			gameThread.interrupt();
		}
		for (Generator generator : generators) {
			generator.stop();
		}
		generators.clear();
	}

	public void addGenerator(Generator generator) {
		generators.add(generator);
	}

	public void startAll() {
		startGameThread();
		startGenerators();
	}

	public void startGameThread() {
		gameThread.start();
	}

	public void startGenerators() {
		for (Generator generator : generators) {
			generator.start();
		}
	}

}
