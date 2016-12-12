package logic.entity;

public class ItemStatus {

	public static ItemStatus instance = new ItemStatus();
	private boolean isFreeze, isFrenzy, isDouble, isInk;
	private int itemTimeCounter;

	public ItemStatus() {
		isFreeze = false;
		isFrenzy = false;
		isDouble = false;
		isInk = false;
	}

	public boolean isFreeze() {
		return isFreeze;
	}

	public void setFreeze(boolean isFreeze) {
		this.isFreeze = isFreeze;
	}

	public boolean isFrenzy() {
		return isFrenzy;
	}

	public void setFrenzy(boolean isFrenzy) {
		this.isFrenzy = isFrenzy;
	}

	public boolean isDouble() {
		return isDouble;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public boolean isInk() {
		return isInk;
	}

	public void setInk(boolean isInk) {
		this.isInk = isInk;
	}

	public int getItemTimeCounter() {
		return itemTimeCounter;
	}

}
