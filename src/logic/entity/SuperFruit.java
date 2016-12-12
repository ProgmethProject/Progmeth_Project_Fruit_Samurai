package logic.entity;

import java.util.Random;

public class SuperFruit extends Fruit {

	public SuperFruit(double x, double y, double speedX, double speedY) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		index = 7 + random.nextInt(3);
		System.out.println(index);
	}

	@Override
	public void cut() {
		super.cut();
		if (index == 7) {
			ItemStatus.instance.setDoubleCounter(5000);
		} else if (index == 8) {
			ItemStatus.instance.setFrenzyCounter(5000);
		} else if (index == 9) {
			ItemStatus.instance.setFreezeCounter(5000);
		}
	}

}
