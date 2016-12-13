package exception;

public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		this.errorType = errorType;
	}

	@Override
	public String getMessage() {
		return errorType == 0 ? "No record score" : "Wrong record format";
	}
}
