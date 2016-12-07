package logic;

import java.util.ArrayList;
import java.util.List;

import gui.ConfigurableSettings;
import main.Main;
import model.Entity;
import model.Fruit;
import model.IRenderable;
import model.RenderableHolder;

public class GameLogic {
	private List<Entity> entities;

	public GameLogic() {
		entities = new ArrayList<>();
		addEntity(new Fruit(0, 0, 50, 500));
	}

	public void updateLogic() {
		for (Entity e : entities) {
			if (e.isDestroyed()) {
				removeEntity(e);
			} else {
				e.update();
			}
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
		RenderableHolder.instance.addEntity(e);
	}

	public void removeEntity(Entity e) {
		entities.remove(e);
		RenderableHolder.instance.removeEntity(e);
	}

}
