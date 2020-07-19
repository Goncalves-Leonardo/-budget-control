package models.entities.enums;

public enum Tag {
	ESSENTIAL("Essential"), SUPERFLUOUS("Superfluous"),
	TRANSPORT("Transport"), MARKET("Market"),
	ENTERTAINMENT("Entertainment"), GOALS("Goals");
	
	private final String option;
	
	Tag(String value) { option = value; }
	
	public String getOption() { return option; }
}
