package models.entities;

import java.math.BigDecimal;
import java.util.List;

import controller.IncomeController;
import models.entities.enums.Types;

public class Account {
	private String name;
	private Types type;
	private BigDecimal amount;
	private String description;
	
	public Account(String name, Types type, BigDecimal amount, String description) {
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", type=" + type + ", amount=" + amount + ", description=" + description + "]";
	}
	
}
