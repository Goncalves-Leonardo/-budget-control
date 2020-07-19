package models.entities.enums;

public enum Types {
	CURRENT_ACCOUNT(0),SAVINGS_ACCOUNT(1),CREDIT_CARD(2),DEBIT_CARD(3),OTHER(4);
	
	private final int value;
	
	Types(int option) {
		value = option;
	}
	
	public int getValue() {
		return value;
	}
}
