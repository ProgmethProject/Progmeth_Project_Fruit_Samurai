package logic.entity;

import java.util.Random;

import graphic.ItemStatus;
import utility.AudioUtility;

public class SuperFruit extends Fruit {

	public SuperFruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = 7 + random.nextInt(3);
	}

	@Override
	public void cut() {
		super.cut();
		if (index == 7) {
			ItemStatus.instance.setDoubleCounter(5000);
			AudioUtility.playSound("kaching");
		} else if (index == 8) {
			ItemStatus.instance.setFrenzyCounter(5000);
			AudioUtility.playSound("faster");
		} else if (index == 9) {
			ItemStatus.instance.setFreezeCounter(5000);
			AudioUtility.playSound("slow");
		}
	}

}
