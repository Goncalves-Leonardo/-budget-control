package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Mock.FakeBD;
import models.entities.Account;
import models.entities.enums.Types;

public class AccountController {
	
	public static void create(String name, String type, BigDecimal amount, String description, FakeBD BD) {
		try {
			Types enumType =  associateType(type);
			Account account = new Account(name,enumType,amount,description);
			BD.accs.add(account);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static List<String>  listTypesChoices() {
		List<String> enumValues = new ArrayList<>();
		for(Types e : Types.values()) {
			enumValues.add(e.getValue());
		}
		return enumValues;
	}
	
	public static Types associateType(String type) {
		switch(type) {
		case "Current Account":
			return Types.CURRENT_ACCOUNT;
		case "Saving Account":
			return Types.SAVING_ACCOUNT;
		case "Credit Card":
			return Types.CREDIT_CARD;
		case "Debit Card":
			return Types.DEBIT_CARD;
		default:
			return Types.OTHER;
		}
	}
	
	
}
