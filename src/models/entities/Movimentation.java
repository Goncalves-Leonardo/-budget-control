package models.entities;

import java.math.BigDecimal;
import java.util.Date;

import models.entities.enums.Tag;

public abstract class Movimentation {
	public static String id;
	public static String name;
	public static BigDecimal value;
	public static Tag[] tags;
	public static Date date;
	public static String account;
	public static String description;
	
	public Movimentation(String name, BigDecimal value,
		Date date, String account) {
		
		this.name        = name;
		this.value       = value;
		this.date        = date;
		this.account     = account;
	}
}
