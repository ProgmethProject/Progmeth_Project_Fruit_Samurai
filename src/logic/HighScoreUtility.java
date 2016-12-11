package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import lib.GameloopUtility;
import main.Main;

public class HighScoreUtility {
	private static String player_name = "";

	public static class HighScoreRecord implements Comparable<HighScoreRecord> {
		private String name = "";
		private int score = 0;

		private HighScoreRecord(String name, int score) {
			/* fill code */
			this.name = name;
			this.score = score;
		}

		/*
		 * Parse the given string "record" record format is name:score
		 */
		public HighScoreRecord(String record) throws ScoreParsingException {
			/* fill code */
			String[] strings = record.split(":");
			if (strings.length != 2)
				throw new ScoreParsingException(1);
			try {
				this.name = strings[0];
				this.score = Integer.parseInt(strings[1]);
			} catch (NumberFormatException e) {
				throw new ScoreParsingException(0);
			}
		}

		private String getRecord() {
			return name.trim() + ":" + score;
		}

		private static String[] defaultRecord() {
			return new String[] { "A:800", "B:350", "C:300", "D:250", "E:200", "F:100", "G:40", "H:30", "I:20",
					"J:10" };
		}

		@Override
		public int compareTo(HighScoreRecord o) {
			/* fill code */
			if (this.score > o.score) {
				return -1;
			} else if (this.score == o.score) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	private static HighScoreRecord[] highScoreRecord = null;

	private static String readFileName = "highscore";

	/*
	 * Display player's score and record if the player rank is 10 or higher.
	 */
	public static void recordHighScore(int score) {
		System.out.println("recordHighScore");
		if (!loadHighScore() || highScoreRecord == null) {
			/* fill code */
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Error loading highscore recordLLLL");
			alert.show();
			return;
		}
		int index = highScoreRecord.length;
		for (int i = 0; i < highScoreRecord.length; i++) {
			if (score > highScoreRecord[i].score) {
				index = i;
				break;
			}
		}
		if (index >= highScoreRecord.length) {
			/* fill code */
			// hint: Alert alert = new Alert(...);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game over");
			alert.setHeaderText(null);
			alert.setContentText("Game over\n" + "Your score is " + score);

			alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
				@Override
				public void handle(DialogEvent event) {
					GameloopUtility.animationTimer.stop();
					System.out.println("Dialog is closed");
					Main.instance.toggleScene();
				}
			});
			/* fill code */
			alert.show();
		} else {
			for (int i = highScoreRecord.length - 1; i >= index + 1; i--) {
				highScoreRecord[i] = highScoreRecord[i - 1];
			}

			TextInputDialog dialog = new TextInputDialog();
			/* fill code */
			dialog.setTitle("High score");
			dialog.setHeaderText(null);
			dialog.setContentText("Congratulation, you are ranked " + index + "\n" + "Please enter your name");

			final int final_index = index;
			dialog.setOnHidden(new EventHandler<DialogEvent>() {

				@Override
				public void handle(DialogEvent event) {
					try {
						String name = ((TextInputDialog) event.getTarget()).getResult();
						if (name != null) {
							highScoreRecord[final_index] = new HighScoreRecord(name, score);
							BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
							/* fill code */
							String string = "";
							for (HighScoreRecord record : highScoreRecord) {
								string += record.getRecord() + "\n";
							}
							// System.out.println(string);
							out.write(getXORed(string));
							out.close();
						}
					} catch (IOException e1) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Error saving high score record");
						alert.setTitle("Error");
						alert.show();
						highScoreRecord = null;
						return;
					}
					GameloopUtility.animationTimer.stop();
					System.out.println("Score is recorded");
					Main.instance.toggleScene();

				}
			});
			dialog.show();
		}
	}

	public static void displayTop10() {
		setReadFileName("highscore");
		if (!loadHighScore() || highScoreRecord == null) {
			/* fill code */
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Error loading highscore record" + loadHighScore());
			alert.showAndWait();
			return;
		}
		String msg = "======= Top 10 players =======" + System.getProperty("line.separator");
		int rank = 1;
		for (HighScoreRecord record : highScoreRecord) {
			msg += rank + " " + record.getRecord() + System.getProperty("line.separator");
			rank++;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Top 10");
		alert.setHeaderText(null);
		alert.setContentText(msg.trim());
		alert.showAndWait();
	}

	private static boolean loadHighScore() {
		File f = new File(readFileName);
		// If no high score, create default

		if (!f.exists()) {
			if (!createDefaultScoreFile())
				return false;
		}
		// Read high score -- if fail: delete the file, create default one and
		// read it again
		if (!readAndParseScoreFile(f)) {
			f.delete();
			if (!createDefaultScoreFile())
				return false;
			return readAndParseScoreFile(f);
		}
		return true;

	}

	private static boolean readAndParseScoreFile(File f) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			highScoreRecord = new HighScoreRecord[10];
			String str = "";
			int c;
			while ((c = in.read()) != -1) {
				str += (char) c;
			}
			in.close();
			String[] records = getXORed(str).split("\n");
			for (int i = 0; i < highScoreRecord.length; i++) {
				try {
					highScoreRecord[i] = new HighScoreRecord(records[i]);
				} catch (ScoreParsingException e) {
					System.err.println("Error parsing line " + (i + 1) + ", " + e.getMessage());
					highScoreRecord[i] = new HighScoreRecord("ERROR_RECORD", 0);
				}
			}
			Arrays.sort(highScoreRecord);
			return true;
		} catch (Exception e) {
			highScoreRecord = null;
		}
		return false;
	}

	private static boolean createDefaultScoreFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for (String s : HighScoreRecord.defaultRecord()) {
				str += s + "\n";
			}
			// System.out.println(str + "=============\n");
			str = str.trim();
			out.write(getXORed(str));
			out.close();
			return true;
		} catch (IOException e1) {
			highScoreRecord = null;
			return false;
		}
	}

	private static final byte[] key = "RmAAq2b5d8fjgu9dhher".getBytes();

	// This method does both encryption and decryption
	private static String getXORed(String in) {
		byte[] inData = in.getBytes();
		/* fill code */
		for (int i = 0; i < inData.length; i++) {
			inData[i] = (byte) (inData[i] ^ key[i % key.length]);
		}
		return new String(inData);
	}

	public static void setReadFileName(String name) {
		readFileName = name;
	}
}
