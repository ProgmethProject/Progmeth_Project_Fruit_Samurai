package logic.highscore;

public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		/* fill code */
		this.errorType = errorType;
	}

	@Override
	public String getMessage() {
		/* fill code */
		return errorType == 0 ? "No record score" : "Wrong record format";
	}
}
