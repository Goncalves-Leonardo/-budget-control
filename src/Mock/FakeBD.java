package Mock;

import java.util.ArrayList;
import java.util.List;

import models.entities.Account;
import models.entities.Income;
import models.entities.Movimentation;
import models.entities.Outcome;

public class FakeBD {
	public List<Account> accs = new ArrayList<>();
	public static List<Movimentation> incomes = new ArrayList<>();
	public static Integer incomeId = 1;
	
	public static List<Movimentation> outcomes = new ArrayList<>();
	public static Integer outcomeId = 1;
	
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

	public static void saveIncome(Income income) {
		System.out.println("Saving Income...");
		String id = String.valueOf(FakeBD.incomeId++);
		income.setId(id);
		FakeBD.incomes.add(income);
		System.out.println("Income Saved!");
	}

	public static List<Movimentation> getMovimentations(String movimentationType) {
		List<Movimentation> movimentations = null;
		
		if (movimentationType == "incomes") {
			movimentations = FakeBD.incomes;
		} else if (movimentationType == "outcomes") {
			movimentations = FakeBD.outcomes;
		}
		
		return movimentations;
	}

	public static void saveOutcome(Outcome outcome) {
		System.out.println("Saving Outcome...");
		String id = String.valueOf(FakeBD.outcomeId++);
		outcome.setId(id);
		FakeBD.outcomes.add(outcome);
		System.out.println("Outcome Saved!");
	}

	public static Movimentation getMovimentation(String movimentationType, String id) {
		List<Movimentation> movimentations = movimentationType == "income" ?
				FakeBD.incomes :
				FakeBD.outcomes;
		
		for (Movimentation movimentation : movimentations) {
			if (movimentation.getId().equals(id)) return movimentation;
		}
		
		return null;
	}
}
