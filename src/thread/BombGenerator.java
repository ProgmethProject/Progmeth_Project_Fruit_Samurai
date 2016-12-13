package thread;

import java.util.Random;

import graphic.PlayerStatus;
import gui.ScreenProperties;
import logic.GameLogic;
import logic.entity.Bomb;
import logic.entity.ItemStatus;
import main.Main;

public class BombGenerator extends Generator {

	public BombGenerator(long generateInterval) {
		super(generateInterval);
	}

	@Override
	public Runnable initRunnable() {
		return () -> {
			while (true) {
				try {
					Thread.sleep(generateInterval);
					if (ItemStatus.instance.getFrenzyCounter() == 0) {
						if (!PlayerStatus.instance.isPause()) {
							Random random = new Random();
							int x = random.nextInt((int) ScreenProperties.screenWidth);
							int y = (int) ScreenProperties.screenHeight;
							int speedX = (100 + random.nextInt(200)) * (x > ScreenProperties.screenWidth / 2 ? -1 : 1);
							int speedY = 700 + random.nextInt(200);
							Main.instance.getGameLogic().addEntity(new Bomb(x, y, speedX, speedY));
						}
					}
				} catch (InterruptedException e) {
					return;
				}
			}
		};
	}
}
