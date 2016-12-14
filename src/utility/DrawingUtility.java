/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package utility;

import java.util.ArrayList;

import graphic.GameAnimation;
import graphic.Trail;
import gui.ScreenProperties;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class DrawingUtility {
	private static Image background;
	private static Image[] overlay;
	private static Image playButton;
	private static Image pauseButton;
	private static Image[] cross;
	private static Image[] fruit;
	private static Image[] cut_fruit;
	private static Image bomb;
	private static Image[] animation;
	private static double modifier = 1.5;
	static {
		loadResource();
	}

	public static Image loadImage(String imgPath, int w, int h) {
		return new Image(ClassLoader.getSystemResource(imgPath).toString(), w * modifier, h * modifier, false, true);
	}

	public static Image loadImageUnmod(String imgPath, int w, int h) {
		return new Image(ClassLoader.getSystemResource(imgPath).toString(), w, h, false, true);
	}

	public static void loadResource() {
		cross = new Image[2];
		cross[0] = loadImage("image/ui/black_cross.png", 50, 60);
		cross[1] = loadImage("image/ui/red_cross.png", 50, 60);

		bomb = loadImage("image/entity/bomb.png", 60, 65);
		playButton = loadImageUnmod("image/ui/play_button.png", 50, 50);
		pauseButton = loadImageUnmod("image/ui/pause_button.png", 50, 50);

		fruit = new Image[10];
		fruit[0] = loadImage("image/entity/apple.png", 60, 50);
		fruit[1] = loadImage("image/entity/grapes.png", 65, 50);
		fruit[2] = loadImage("image/entity/mango.png", 70, 50);
		fruit[3] = loadImage("image/entity/orange.png", 50, 50);
		fruit[4] = loadImage("image/entity/peach.png", 55, 55);
		fruit[5] = loadImage("image/entity/raspberry.png", 50, 50);
		fruit[6] = loadImage("image/entity/strawberry.png", 45, 55);
		fruit[7] = loadImage("image/entity/banana_king.png", 80, 55);
		fruit[8] = loadImage("image/entity/banana_fire.png", 78, 65);
		fruit[9] = loadImage("image/entity/frozen_banana.png", 65, 65);

		cut_fruit = new Image[20];
		cut_fruit[0] = loadImage("image/cut_entity/apple1.png", 60, 50);
		cut_fruit[1] = loadImage("image/cut_entity/apple2.png", 60, 50);
		cut_fruit[2] = loadImage("image/cut_entity/grapes1.png", 65, 50);
		cut_fruit[3] = loadImage("image/cut_entity/grapes2.png", 65, 50);
		cut_fruit[4] = loadImage("image/cut_entity/mango1.png", 70, 50);
		cut_fruit[5] = loadImage("image/cut_entity/mango2.png", 70, 50);
		cut_fruit[6] = loadImage("image/cut_entity/orange1.png", 50, 50);
		cut_fruit[7] = loadImage("image/cut_entity/orange2.png", 50, 50);
		cut_fruit[8] = loadImage("image/cut_entity/peach1.png", 55, 55);
		cut_fruit[9] = loadImage("image/cut_entity/peach2.png", 55, 55);
		cut_fruit[10] = loadImage("image/cut_entity/raspberry1.png", 50, 50);
		cut_fruit[11] = loadImage("image/cut_entity/raspberry2.png", 50, 50);
		cut_fruit[12] = loadImage("image/cut_entity/strawberry1.png", 45, 55);
		cut_fruit[13] = loadImage("image/cut_entity/strawberry2.png", 45, 55);
		cut_fruit[14] = loadImage("image/cut_entity/banana_king1.png", 80, 55);
		cut_fruit[15] = loadImage("image/cut_entity/banana_king2.png", 80, 55);
		cut_fruit[16] = loadImage("image/cut_entity/banana_fire1.png", 78, 65);
		cut_fruit[17] = loadImage("image/cut_entity/banana_fire2.png", 78, 65);
		cut_fruit[18] = loadImage("image/cut_entity/frozen_banana1.png", 65, 65);
		cut_fruit[19] = loadImage("image/cut_entity/frozen_banana2.png", 65, 65);

		animation = new Image[5];
		animation[0] = loadImage("image/animation/bombanim2.png", 1280, 146);
		animation[1] = loadImage("image/animation/cutanim1.png", 1040, 130);
		animation[2] = loadImage("image/animation/cutanim2.png", 1040, 130);
		animation[3] = loadImage("image/animation/cutanim3.png", 1040, 130);
		animation[4] = loadImage("image/animation/cutanim4.png", 1040, 130);

		overlay = new Image[3];
		overlay[0] = loadImageUnmod("image/background/confetti.png", ScreenProperties.screenWidth,
				ScreenProperties.screenHeight);
		overlay[1] = loadImageUnmod("image/background/flame.png", ScreenProperties.screenWidth,
				ScreenProperties.screenHeight);
		overlay[2] = loadImageUnmod("image/background/snow.png", ScreenProperties.screenWidth,
				ScreenProperties.screenHeight);

		background = loadImageUnmod("image/background/background.jpg", ScreenProperties.screenWidth,
				ScreenProperties.screenHeight);

	}

	public static void drawLife(GraphicsContext gc, double x, double y, int healthPoint) {
		int cross1, cross2, cross3;
		switch (healthPoint) {
		case 3:
			cross1 = 0;
			cross2 = 0;
			cross3 = 0;
			break;
		case 2:
			cross1 = 0;
			cross2 = 0;
			cross3 = 1;
			break;
		case 1:
			cross1 = 0;
			cross2 = 1;
			cross3 = 1;
			break;
		case 0:
			cross1 = 1;
			cross2 = 1;
			cross3 = 1;
			break;
		default:
			cross1 = 0;
			cross2 = 0;
			cross3 = 0;
			break;
		}
		gc.drawImage(cross[cross1], x, y, 30, 36);
		gc.drawImage(cross[cross2], x + 35, y, 30, 36);
		gc.drawImage(cross[cross3], x + 70, y, 30, 36);
	}

	public static GameAnimation createCuttingAnimation(int x, int y, int comboCount) {
		GameAnimation anim;
		if (Trail.instance.getSlashColor() == 5) {
			anim = new GameAnimation(DrawingUtility.animation[(int) (Math.random() * 4) + 1], 8, 1, comboCount);
		} else {
			anim = new GameAnimation(DrawingUtility.animation[Trail.instance.getSlashColor()], 8, 1, comboCount);
		}
		anim.centerAnimationAt(x, y);
		anim.play();
		return anim;
	}

	public static GameAnimation createBombAnimation(int x, int y) {
		GameAnimation anim = new GameAnimation(DrawingUtility.animation[0], 8, 1);
		anim.centerAnimationAt((int) (x + bomb.getWidth() / 2), (int) (y + bomb.getHeight() / 2));
		anim.play();
		return anim;
	}

	public static void rotate(GraphicsContext gc, double angle, double px, double py) {
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	public static void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
		gc.save(); // saves the current state on stack, including the current
					// transform
		rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
		gc.drawImage(image, tlpx, tlpy);
		gc.restore(); // back to original state (before rotation)
	}

	public static void drawFruit(GraphicsContext gc, int index, double rotation, double x, double y) {
		drawRotatedImage(gc, fruit[index], rotation, x, y);
	}

	public static void drawBomb(GraphicsContext gc, double rotation, double x, double y) {
		drawRotatedImage(gc, bomb, rotation, x, y);
	}

	public static void drawHalfFruit(GraphicsContext gc, int index, int side, double rotation, double x, double y) {
		drawRotatedImage(gc, cut_fruit[index * 2 + side], rotation, x, y);
	}

	public static void drawOverlay(GraphicsContext gc, int index) {
		gc.drawImage(overlay[index], 0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
	}

	public static void drawBackground(GraphicsContext gc) {
		gc.drawImage(background, 0, 0, ScreenProperties.screenWidth, ScreenProperties.screenHeight);
	}

	public static void drawPlayButton(GraphicsContext gc, int buttonSize) {
		gc.drawImage(playButton, 10, 10, buttonSize, buttonSize);
	}

	public static void drawPauseButton(GraphicsContext gc, int buttonSize) {
		gc.drawImage(pauseButton, 10, 10, buttonSize, buttonSize);
	}

	public static Image getFruit(int index) {
		return fruit[index];
	}

	public static Image getBomb() {
		return bomb;
	}

}
