//package Utility;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import javafx.scene.image.WritableImage;
//import model.IRenderable;
//
//public class GameAnimation implements IRenderable {
//
//	private Image image = null;
//	private int frameCount, frameDelay;
//	private int currentFrame, frameDelayCount;
//	private int x, y, frameWidth, frameHeight;
//	private boolean visible = false, playing = false;
//
//	public GameAnimation(Image cutanim, int frameCount, int frameDelay) {
//		this.frameCount = frameCount;
//		this.frameDelay = frameDelay;
//		currentFrame = 0;
//		frameDelayCount = 0;
//		image = DrawingUtility.cutanim;
//		x = 0;
//		y = 0;
//		if (image != null) {
//			frameHeight = 100;
//			frameWidth = 100;
//		} 
//		else {
//			frameHeight = 0;
//			frameWidth = 0;
//		}
//	}
//
//	protected void topLeftAnimationAt(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	protected void centerAnimationAt(int x, int y) {
//		this.x = x - frameWidth / 2;
//		this.y = y - frameHeight / 2;
//	}
//
//	public void play() {
//		currentFrame = 0;
//		playing = true;
//		visible = true;
//	}
//
//	public void stop() {
//		currentFrame = 0;
//		playing = false;
//		visible = false;
//	}
//
//	public void updateAnimation() {
//		if (!playing)
//			return;
//		if (frameDelayCount > 0) {
//			frameDelayCount--;
//			return;
//		}
//		frameDelayCount = frameDelay;
//		currentFrame++;
//		if (currentFrame == frameCount) {
//			stop();
//		}
//	}
//	@Override
//	public boolean isDestroyed() {
//		return visible;
//	}
//
//	@Override
//	public int getZ() {
//		return Integer.MAX_VALUE - 1;
//	}
//
//	@Override
//	public void draw(GraphicsContext gc) {
//		if(!visible || image == null) {
//			return;
//		}
//		WritableImage croppedImage = new WritableImage(image.getPixelReader(), currentFrame*130, 0, 130, 130);
//		gc.drawImage(croppedImage, x, y);
//	}
//
//}
