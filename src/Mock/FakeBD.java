package Mock;

import java.util.ArrayList;
import java.util.List;

import models.entities.Account;
import models.entities.Income;

public class FakeBD {
	public List<Account> accs = new ArrayList<>();
	public static List<Income> incomes = new ArrayList<>();
	
	@Override
	public String toString() {
		
		String format = "";
		
		for(Account acc : accs) {
			format += acc.getName() 
					+ " - " 
					+ acc.getType().getValue() 
					+ " - "
					+ acc.getAmount()
					+ " - "
					+ acc.getDescription()
					+ "\n";
		}
		
		return format;
	}
}
