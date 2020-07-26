package models.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Income extends Movimentation {

	public Income(String name, BigDecimal value, Date date, String account) {
		super(name, value, date, account);
	}

	@Override
	public String toString() {
		return "Name: " + this.name + 
			"\nValue: " + this.value + 
			"\nDate: " + this.date + 
			"\nAccountId: " + this.account;
	}
}
