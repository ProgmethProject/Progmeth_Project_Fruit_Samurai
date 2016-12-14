/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package logic.entity;

import graphic.IRenderable;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import gui.ScreenProperties;

public abstract class Entity implements IRenderable {

	public static final double GRAVITY = 700;
	private static double modifier;
	protected double x, y, speedX, speedY;
	protected double rotation;
	protected int z;
	protected boolean isDestroyed;

	public Entity(double x, double y, double speedX, double speedY) {
		super();
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.z = RenderableHolder.instance.getMaxZ() + 1;
		this.isDestroyed = false;
		this.rotation = 0;
		modifier = 1;
	}

	public static void setModifier(double modifier) {
		Entity.modifier = modifier;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public void move() {

		this.x += speedX * modifier / 1000;
		this.y -= speedY * modifier / 1000;
		this.speedY -= GRAVITY * modifier / 1000;

		this.rotation += ((double) 270 / 1000) * (speedX > 0 ? 1 : -1);
	}

	public void update() {
		if (this.x > ScreenProperties.screenWidth || this.x < -50 || this.y > ScreenProperties.screenHeight) {
			setDestroyed(true);
			if (this instanceof Fruit) {
				PlayerStatus.instance.resetComboCount();
				PlayerStatus.instance.setOnCombo(false);
			}
		}
		if (!isDestroyed) {
			move();
			if (this instanceof Cuttable) {
				Cuttable cuttable = (Cuttable) this;
				if (cuttable.isCut()) {
					cuttable.cut();
				}
			}
		}
	}

}
