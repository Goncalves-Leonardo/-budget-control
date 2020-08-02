package models.entities;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Override
	public String toString() {
		return "Id: " + this.id +
			"\nName: " + this.name + 
			"\nValue: " + this.value + 
			"\nDate: " + this.date + 
			"\nAccountId: " + this.account;
	}
	
	public void setId(String id) { this.id = id; }
	public String getId() { return this.id; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setValue(BigDecimal value) { this.value = value; }
	public BigDecimal getValue() { return this.value; }
	
	public void setAccount(String accountId) { this.account = accountId; }
	public String getAcccountId() { return this.account; }

	public void setDate(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);
        
		this.date = date;
	}
	
	public String getDateString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(this.date);
	}
}
