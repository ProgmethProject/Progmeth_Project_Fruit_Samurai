package Utility;

import javafx.scene.media.AudioClip;

public class AudioUtility {

	private static AudioClip sound_bomb;
	private static AudioClip sound_slash;
	static {
		loadResource();
	}

	public static void loadResource() {
		sound_bomb = new AudioClip(ClassLoader.getSystemResource("sound/bomb.wav").toString());
		sound_slash = new AudioClip(ClassLoader.getSystemResource("sound/slash.wav").toString());
	}

	public static void playSound(String identifier) {
		switch (identifier) {
		case "bomb":
			sound_bomb.play();
			break;
		case "slash":
			sound_slash.play();
			break;
		}
	}
}
