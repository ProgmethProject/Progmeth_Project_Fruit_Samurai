package thread;

import java.util.Random;

import graphic.PlayerStatus;
import gui.ScreenProperties;
import logic.GameLogic;
import logic.entity.Bomb;
import logic.entity.ItemStatus;

public class BombGenerator extends Generator {
	private GameLogic gameLogic;

	public BombGenerator(GameLogic gameLogic, long generateInterval) {
		super(generateInterval);
		this.gameLogic = gameLogic;
	}

	@Override
	public Runnable initRunnable() {
		return () -> {
			while (true) {
				try {
					if (ItemStatus.instance.getFrenzyCounter() == 0) {
						if (!PlayerStatus.instance.isPause()) {
							Random random = new Random();
							int x = random.nextInt((int) ScreenProperties.screenWidth);
							int y = (int) ScreenProperties.screenHeight;
							int speedX = (100 + random.nextInt(200)) * (x > ScreenProperties.screenWidth / 2 ? -1 : 1);
							int speedY = 700 + random.nextInt(200);
							gameLogic.addEntity(new Bomb(x, y, speedX, speedY));
						}
					}
					Thread.sleep(generateInterval);
				} catch (InterruptedException e) {
					return;
				}
			}
		};
	}
}
