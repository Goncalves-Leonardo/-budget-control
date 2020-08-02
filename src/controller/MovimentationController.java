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
import models.entities.Movimentation;
import models.entities.Outcome;

public class MovimentationController {
	public static List<Movimentation> list(String movimentationType) {
		return FakeBD.getMovimentations(movimentationType);
	}

    public static void create(String movimentationType, Map<String, String> fields)
    		throws ParseException {
        String name        = fields.get("name");
        String valueString = fields.get("value");
        String dateString  = fields.get("date");
        String accountId   = fields.get("account");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);
        
        if (movimentationType == "income") {
        	BigDecimal value = new BigDecimal(valueString);            
        	
        	Income income = new Income(name, value, date, accountId);
            FakeBD.saveIncome(income);
        } else if (movimentationType == "outcome") {
        	BigDecimal multiplicand = new BigDecimal("-1");
        	BigDecimal value = new BigDecimal(valueString).multiply(multiplicand);            
        	
        	Outcome outcome = new Outcome(name, value, date, accountId);
            FakeBD.saveOutcome(outcome);
        }
    }

	public static void edit(String movimentationType, Map<String, String> fields)
			throws ParseException {
		String id          = fields.get("id");
		String name        = fields.get("name");
        String valueString = fields.get("value");
        String dateString  = fields.get("date");
        String accountId   = fields.get("account");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);
		
        Movimentation movimentation = FakeBD.getMovimentation(movimentationType, id);
        movimentation.setName(name);
        movimentation.setDate(date);
        movimentation.setAccount(accountId);
        
        if (movimentationType == "income") {
        	movimentation.setValue(new BigDecimal(valueString));
        	FakeBD.saveIncome((Income) movimentation);
        } else if (movimentationType == "outcome") {
        	BigDecimal multiplicand = new BigDecimal("-1");
        	BigDecimal value = new BigDecimal(valueString).multiply(multiplicand);
        	movimentation.setValue(value);
        	FakeBD.saveOutcome((Outcome) movimentation);
        }
	}
}
