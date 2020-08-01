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

	public String getId() { return this.id; }

	public void setName(String name) { this.name = name; }

	public void setValue(BigDecimal value) { this.value = value; }

	public void setDate(Date date) { this.date = date; }

	public void setAccount(String accountId) { this.account = accountId; }

	public void setId(String id) { this.id = id; }
}
