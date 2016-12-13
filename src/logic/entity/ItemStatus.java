package logic.entity;

import java.util.ArrayList;
import java.util.List;

import Utility.DrawingUtility;
import graphic.PlayerStatus;
import gui.ScreenProperties;
import javafx.scene.canvas.GraphicsContext;
import main.Main;
import thread.FruitGenerator;
import thread.Generator;

public class ItemStatus implements IRenderable {

	public static ItemStatus instance = new ItemStatus();
	private int freezeCounter, frenzyCounter, doubleCounter;
	List<Generator> frenzyGenerator;

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
				frenzyGenerator.add(new FruitGenerator(Main.instance.getGameLogic(), 1000));
				frenzyGenerator.add(new FruitGenerator(Main.instance.getGameLogic(), 2000));
				frenzyGenerator.add(new FruitGenerator(Main.instance.getGameLogic(), 3000));
				frenzyGenerator.add(new FruitGenerator(Main.instance.getGameLogic(), 4000));
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
			gc.drawImage(DrawingUtility.overlay[1], 0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
		}

		if (freezeCounter > 0) {
			gc.drawImage(DrawingUtility.overlay[2], 0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
		}

		if (doubleCounter > 0) {
			gc.drawImage(DrawingUtility.overlay[0], 0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
		}
	}
}
