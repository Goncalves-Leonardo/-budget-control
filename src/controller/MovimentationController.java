package controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Mock.FakeBD;
import models.entities.Income;
import models.entities.Movimentation;
import models.entities.Outcome;

public class MovimentationController {
	public static Set<Movimentation> list(String movimentationType) {
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
        
        BigDecimal value = new BigDecimal(valueString);            
    	Movimentation movimentation = null;
        
        if (movimentationType == "income") {
        	movimentation = new Income(name, value, date, accountId);
        } else if (movimentationType == "outcome") {
        	movimentation = new Outcome(name, value, date, accountId);
        }
        FakeBD.saveMovimentation(movimentationType, movimentation);
    }

	public static void edit(String movimentationType, Map<String, String> fields)
			throws ParseException {
		String id = fields.get("id");
		Movimentation movimentation = FakeBD.getMovimentation(movimentationType, id);
        
		String name        = fields.containsKey("name")    ? fields.get("name")    : movimentation.getName();
        String valueString = fields.containsKey("value")   ? fields.get("value")   : movimentation.getValue().toString();
        String accountId   = fields.containsKey("account") ? fields.get("account") : movimentation.getAcccountId();
        String dateString  = fields.containsKey("date")    ? fields.get("date")    : movimentation.getDateString();
        
        movimentation.setName(name);
        movimentation.setDate(dateString);
        movimentation.setAccount(accountId);
        
        BigDecimal value = new BigDecimal(valueString);
        movimentation.setValue(value);
        FakeBD.editMovimentation(movimentationType, movimentation);
	}

	public static void delete(String movimentationType, String id) {
		Boolean notFound = true;
		Set<Movimentation> movimentations = movimentationType == "income" ?
				FakeBD.incomes :
				FakeBD.outcomes;
		
		Iterator<Movimentation> movimentationIterator = movimentations.iterator();
		Movimentation currentMovimentation;
		while (movimentationIterator.hasNext() && notFound) {
			currentMovimentation = movimentationIterator.next();
			if (currentMovimentation.getId().equals(id)) {
				notFound = false;
				movimentationIterator.remove();
			}
		}
	}
}
