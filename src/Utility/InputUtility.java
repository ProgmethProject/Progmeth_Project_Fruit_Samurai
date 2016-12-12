package Utility;


public class InputUtility {

	private static int mouseX, mouseY, prevMouseX, prevMouseY, releaseX, releaseY;
	private static boolean mouseLeftDown, mouseOnScreen;
	private static boolean mouseLeftLastDown;
	private static boolean isDrag;

	public static boolean isDrag() {
		return isDrag;
	}

	public static int getPrevMouseX() {
		return prevMouseX;
	}

	public static int getPrevMouseY() {
		return prevMouseY;
	}

	public static void setDrag(boolean isDrag) {
		InputUtility.isDrag = isDrag;
	}

	public static int getMouseX() {
		return InputUtility.mouseX;
	}

	public static void setMouseX(int mouseX) {
		InputUtility.prevMouseX = InputUtility.mouseX;
		InputUtility.mouseX = mouseX;
	}

	public static int getMouseY() {
		return InputUtility.mouseY;
	}

	public static void setMouseY(int mouseY) {
		InputUtility.prevMouseY = InputUtility.mouseY;
		InputUtility.mouseY = mouseY;
	}

	public static int getMouseSpeed(){
		int delX = mouseX-prevMouseX;
		int delY = mouseY-prevMouseY;
		
		return delX*delX+delY*delY;
	}
	
	public static double getMouseAngle(){
		int delX = mouseX-prevMouseX;
		int delY = mouseY-prevMouseY;
		
		return Math.atan((double)delY/(double)delX);
	}
	
	public static int getReleaseX() {
		return releaseX;
	}

	public static void setReleaseX(int releaseX) {
		InputUtility.releaseX = releaseX;
	}

	public static int getReleaseY() {
		return releaseY;
	}

	public static void setReleaseY(int releaseY) {
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

	public static boolean isMouseLeftClicked() {
		return InputUtility.mouseLeftLastDown;
	}

	public static void setMouseLeftLastDown(boolean v) {
		InputUtility.mouseLeftLastDown = v;
	}

	public static void postUpdate() {
		setMouseLeftLastDown(false);
	}

}
