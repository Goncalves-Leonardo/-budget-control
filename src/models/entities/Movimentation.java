package models.entities;

import java.math.BigDecimal;
import java.util.Date;

import models.entities.enums.Tag;

public abstract class Movimentation {
	public String id;
	public String name;
	public BigDecimal value;
	public Tag[] tags;
	public Date date;
	public String account;
	public String description;
	
	public Movimentation(String name, BigDecimal value,
		Date date, String account) {
		
		this.name        = name;
		this.value       = value;
		this.date        = date;
		this.account     = account;
	}
}
