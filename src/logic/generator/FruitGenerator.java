package logic.generator;

import java.util.Random;

import gui.ScreenProperties;
import logic.GameLogic;
import logic.entity.Fruit;
import logic.entity.SuperFruit;

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
					int speedX = (100 + random.nextInt(200)) * (x > ScreenProperties.screenWidth / 2 ? -1 : 1);
					int speedY = 700 + random.nextInt(200);
					gameLogic.addEntity(random.nextInt(10) != 0 ? new Fruit(x, y, speedX, speedY)
							: new SuperFruit(x, y, speedX, speedY));
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
