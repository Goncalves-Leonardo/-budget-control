package models.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Outcome extends Movimentation {

	public Outcome(String name, BigDecimal value, Date date, String account) {
		super(name, value, date, account);
	}
}
