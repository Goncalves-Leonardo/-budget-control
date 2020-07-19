package models.entities.enums;

public enum Types {
	CURRENT_ACCOUNT("Current Account"),
	SAVING_ACCOUNT("Saving Account"),
	CREDIT_CARD("Credit Card"),
	DEBIT_CARD("Debit Card"),
	OTHER("Other");
	
	private final String value;
	
	Types(String option) {
		value = option;
	}
	
	public String getValue() {
		return value;
	}
}
