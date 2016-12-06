package logic;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

import gui.ConfigurableSettings;
import main.Main;
import model.Entity;
import model.Fruit;
import model.IRenderable;
import model.RenderableHolder;

public class GameLogic implements Runnable {
	private List<IRenderable> renderables;

	public GameLogic() {
		renderables = RenderableHolder.instance.getEntities();
	}

	@Override
	public void run() {
		System.out.println(renderables.size());
		RenderableHolder.instance.addEntity(new Fruit(200, ConfigurableSettings.screenHeight, 50, 500));
		while (true) {
			for (IRenderable iRenderable : renderables) {
				if (iRenderable instanceof Entity) {
					Entity entity = (Entity)iRenderable;
					entity.move();
				}
			}
			Main.instance.drawGameScreen();

			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}