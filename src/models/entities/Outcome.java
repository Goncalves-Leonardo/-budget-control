package models.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Outcome extends Movimentation {

	public Outcome(String name, BigDecimal value, Date date, String account) {
		super(name, value, date, account);
		this.setValue(value);
	}
	
	@Override
	public void setValue(BigDecimal value) {
		BigDecimal multiplicand = new BigDecimal("-1");
		super.setValue(value.multiply(multiplicand));
	}
}
