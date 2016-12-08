package model;

import graphic.RenderableHolder;
import gui.ConfigurableSettings;
import logic.GameLogic;

public abstract class Entity implements IRenderable {

	public static double GRAVITY = 300;

	protected double x, y, speedX, speedY;
	protected int z;
	protected boolean isDestroyed;

	public Entity(double x, double y, double speedX, double speedY) {
		super();
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.z = RenderableHolder.instance.getMaxZ() + 1;
		isDestroyed = false;
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
		this.x += speedX / 60;
		this.y -= speedY / 60;
		speedY -= GRAVITY / 60;
	}

	public void update() {
		if (this.x > ConfigurableSettings.screenWidth || this.x < 0) {
			setDestroyed(true);
		}
		if (!isDestroyed) {
			move();
		}
	}

}
