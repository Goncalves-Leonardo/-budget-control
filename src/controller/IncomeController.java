package controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import Mock.FakeBD;
import models.entities.Income;

public class IncomeController {
	
	public static List<Income> list() {
		List<Income> incomes = FakeBD.getIncomes();
		return incomes;
	}

    public static void create(Map<String, String> fields) throws ParseException {
        String name       = fields.get("name");
        String value      = fields.get("value");
        String dateString = fields.get("date");
        String accountId  = fields.get("account");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);

        Income income = new Income(name, new BigDecimal(value), date, accountId);
        income.setId("1");
        FakeBD.incomes.add(income);
        System.out.println(FakeBD.incomes.get(0));
        FakeBD.saveIncome(income);
    }
    
    public static void edit(Map<String, String> fields) throws ParseException {
		String incomeId   = fields.get("id");
		String name       = fields.get("name");
        String value      = fields.get("value");
        String dateString = fields.get("date");
        String accountId  = fields.get("account");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);
		
        Income income = FakeBD.getIncome(incomeId);
		income.setName(name);
		income.setValue(new BigDecimal(value));
		income.setDate(date);
		income.setAccount(accountId);
		System.out.println();
		System.out.println(FakeBD.incomes.get(0));
		FakeBD.saveIncome(income);
	}
}