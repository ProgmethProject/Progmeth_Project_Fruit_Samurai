package utility;

public class InputUtility {

	private static double mouseX, mouseY, prevMouseX, prevMouseY, releaseX, releaseY;
	private static boolean mouseLeftDown, mouseOnScreen;

	public static double getPrevMouseX() {
		return prevMouseX;
	}

	public static double getPrevMouseY() {
		return prevMouseY;
	}

	public static double getMouseX() {
		return InputUtility.mouseX;
	}

	public static void setMouseX(double mouseX) {
		InputUtility.prevMouseX = InputUtility.mouseX;
		InputUtility.mouseX = mouseX;
	}

	public static double getMouseY() {
		return InputUtility.mouseY;
	}

	public static void setMouseY(double mouseY) {
		InputUtility.prevMouseY = InputUtility.mouseY;
		InputUtility.mouseY = mouseY;
	}

	public static double getMouseSpeed() {
		double delX = mouseX - prevMouseX;
		double delY = mouseY - prevMouseY;

		return delX * delX + delY * delY;
	}

	public static double getMouseAngle() {
		double delX = mouseX - prevMouseX;
		double delY = mouseY - prevMouseY;

		return Math.atan(delY /  delX);
	}

	public static double getReleaseX() {
		return releaseX;
	}

	public static void setReleaseX(double releaseX) {
		InputUtility.releaseX = releaseX;
	}

	public static double getReleaseY() {
		return releaseY;
	}

	public static void setReleaseY(double releaseY) {
		InputUtility.releaseY = releaseY;
	}

	public static boolean isMouseLeftDown() {
		return InputUtility.mouseLeftDown;
	}

	public static void setMouseLeftDown(boolean mouseLeftDown) {
		InputUtility.mouseLeftDown = mouseLeftDown;
	}

	public static boolean isMouseOnScreen() {
		return InputUtility.mouseOnScreen;
	}

	public static void setMouseOnScreen(boolean mouseOnScreen) {
		InputUtility.mouseOnScreen = mouseOnScreen;
	}

}
