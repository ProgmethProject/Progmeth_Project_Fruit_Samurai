package logic;

import java.util.ArrayList;
import java.util.List;

import graphic.PlayerStatus;
import graphic.RenderableHolder;
import logic.entity.Fruit;
import logic.generator.BombGenerator;
import logic.generator.FruitGenerator;
import model.Entity;

public class GameLogic {
	private List<Entity> entities;
	private FruitGenerator mainFruitGenerator;
	private BombGenerator mainBombGenerator;

	public GameLogic() {

		entities = new ArrayList<>();

		mainFruitGenerator = new FruitGenerator(this, 2000);
		mainBombGenerator = new BombGenerator(this, 3000);
		mainFruitGenerator.start();
		mainBombGenerator.start();

		Fruit fruit = new Fruit(100, 100, 50, 200);
		addEntity(fruit);
	}

	synchronized public void updateLogic() {
		if (!PlayerStatus.instance.isPause()) {
			for (int i = entities.size() - 1; i >= 0; i--) {
				Entity e = entities.get(i);
				if (e.isDestroyed()) {
					removeEntity(e);
				} else {
					e.update();
				}
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
	
	public void initGame(){
		clearEntity();
		PlayerStatus.instance.initPlayer(PlayerStatus.DEFAULT_HP);
	}

}
