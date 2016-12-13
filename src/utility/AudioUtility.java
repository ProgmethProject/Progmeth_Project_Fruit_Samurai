package utility;

import javafx.scene.media.AudioClip;

public class AudioUtility {

	private static AudioClip sound_bomb, sound_slash, sound_slow, sound_kaching, sound_faster;
	static {
		loadResource();
	}

	public static void loadResource() {
		sound_bomb = new AudioClip(ClassLoader.getSystemResource("sound/bomb.wav").toString());
		sound_slash = new AudioClip(ClassLoader.getSystemResource("sound/slash.wav").toString());
		sound_slow = new AudioClip(ClassLoader.getSystemResource("sound/slow.wav").toString());
		sound_kaching = new AudioClip(ClassLoader.getSystemResource("sound/kaching.wav").toString());
		sound_faster = new AudioClip(ClassLoader.getSystemResource("sound/faster.wav").toString());
	}

	public static void playSound(String identifier) {
		switch (identifier) {
		case "bomb":
			sound_bomb.play();
			break;
		case "slash":
			sound_slash.play();
			break;
		case "slow":
			sound_slow.play();
			break;
		case "kaching":
			sound_kaching.play();
			break;
		case "faster":
			sound_faster.play();
			break;
		}
	}
}
