package logic.generator;

import java.util.Random;

import gui.ScreenProperties;
import logic.GameLogic;
import logic.entity.Fruit;

public class FruitGenerator extends Generator {

	private GameLogic gameLogic;

	public FruitGenerator(GameLogic gameLogic, long generateInterval) {
		super(generateInterval);
		this.gameLogic = gameLogic;
	}

	@Override
	public Runnable initRunnable() {
		return () -> {
			while (true) {
				try {
					Random random = new Random();
					int x = random.nextInt((int) ScreenProperties.screenWidth);
					int y = (int) ScreenProperties.screenHeight;
					int speedX = (50 + random.nextInt(200)) * (random.nextInt(2) == 0 ? -1 : 1);
					int speedY = 700 + random.nextInt(200);
					gameLogic.addEntity(new Fruit(x, y, speedX, speedY));
					Thread.sleep(generateInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Generator interrupted");
					return;
				}
			}
		};
	}

}
