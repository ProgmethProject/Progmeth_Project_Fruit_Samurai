/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import graphic.Background;
import graphic.ItemStatus;
import graphic.MenuButton;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import graphic.Trail;
import logic.entity.Entity;

public class GameLogic {
	private List<Entity> entities;

	public GameLogic() {
		entities = new ArrayList<>();
	}

	synchronized public void updateLogic() {

		for (int i = entities.size() - 1; i >= 0; i--) {
			Entity e = entities.get(i);
			if (e.isDestroyed()) {
				removeEntity(e);
			} else {
				e.update();
			}
		}
	}

	synchronized public void addEntity(Entity e) {
		entities.add(e);
		RenderableHolder.instance.addEntity(e);
	}

	synchronized public void removeEntity(Entity e) {
		entities.remove(e);
		RenderableHolder.instance.removeEntity(e);
	}

	synchronized public void clearEntity() {
		entities.clear();
		RenderableHolder.instance.clearEntity();
	}

	public void initGame() {
		clearEntity();
		PlayerStatus.instance.initPlayer(PlayerStatus.DEFAULT_HP);
		RenderableHolder.instance.addEntity(Background.instance);
		RenderableHolder.instance.addEntity(PlayerStatus.instance);
		RenderableHolder.instance.addEntity(MenuButton.instance);
		RenderableHolder.instance.addEntity(Trail.instance);
		RenderableHolder.instance.addEntity(ItemStatus.instance);
	}

}
