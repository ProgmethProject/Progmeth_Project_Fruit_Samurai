package graphic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.Entity;
import thread.FruitGenerator;
import thread.Generator;
import utility.DrawingUtility;

public class ItemStatus implements IRenderable {

	public static ItemStatus instance = new ItemStatus();
	private int freezeCounter, frenzyCounter, doubleCounter;
	private List<Generator> frenzyGenerator;

	public ItemStatus() {
		freezeCounter = 0;
		frenzyCounter = 0;
		doubleCounter = 0;
		frenzyGenerator = new ArrayList<>();
	}

	public void resetAllCounter() {
		freezeCounter = 0;
		frenzyCounter = 0;
		doubleCounter = 0;
	}

	public int getFreezeCounter() {
		return freezeCounter;
	}

	public void setFreezeCounter(int freezeCounter) {
		this.freezeCounter = freezeCounter;
	}

	public int getFrenzyCounter() {
		return frenzyCounter;
	}

	public void setFrenzyCounter(int frenzyCounter) {
		this.frenzyCounter = frenzyCounter;
	}

	public int getDoubleCounter() {
		return doubleCounter;
	}

	public void setDoubleCounter(int doubleCounter) {
		this.doubleCounter = doubleCounter;
	}

	public void update() {
		if (freezeCounter > 0) {
			Entity.setModifier(0.5);
			freezeCounter--;
		} else {
			Entity.setModifier(1);
		}
		if (frenzyCounter > 0) {
			if (frenzyGenerator.size() == 0) {
				frenzyGenerator.add(new FruitGenerator(1000));
				frenzyGenerator.add(new FruitGenerator(2000));
				frenzyGenerator.add(new FruitGenerator(3000));
				frenzyGenerator.add(new FruitGenerator(4000));
				for (Generator generator : frenzyGenerator) {
					generator.start();
				}
			}
			frenzyCounter--;
		} else {
			for (Generator generator : frenzyGenerator) {
				generator.stop();
			}
			frenzyGenerator.clear();
		}
		if (doubleCounter > 0) {
			PlayerStatus.instance.setScoreModifier(2);
			doubleCounter--;
		} else {
			PlayerStatus.instance.setScoreModifier(1);
		}
	}

	@Override
	public int getZ() {
		return Integer.MIN_VALUE + 1;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (frenzyCounter > 0) {
			DrawingUtility.drawOverlay(gc, 1);
		}

		if (freezeCounter > 0) {
			DrawingUtility.drawOverlay(gc, 2);
		}

		if (doubleCounter > 0) {
			DrawingUtility.drawOverlay(gc, 0);
		}
	}
}
