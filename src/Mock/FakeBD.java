package Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import models.entities.Account;
import models.entities.Movimentation;

public class FakeBD {
	public List<Account> accs = new ArrayList<>();
	public static Set<Movimentation> incomes = new HashSet<>();
	public static Integer incomeId = 1;
	
	public static Set<Movimentation> outcomes = new HashSet<>();
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

	public static Set<Movimentation> getMovimentations(String movimentationType) {
		Set<Movimentation> movimentations = null;
		
		if (movimentationType == "incomes") {
			movimentations = FakeBD.incomes;
		} else if (movimentationType == "outcomes") {
			movimentations = FakeBD.outcomes;
		}
		
		return movimentations;
	}
	
	public static void saveMovimentation(String movimentationType, Movimentation movimentation) {
		Set<Movimentation> movimentations;
		Integer movimentationId;
		
		if (movimentationType.equals("income")) {
			movimentations = FakeBD.incomes;
			movimentationId = FakeBD.incomeId++;
		} else {
			movimentations = FakeBD.outcomes;
			movimentationId = FakeBD.outcomeId++;
		}
		
		String id = String.valueOf(movimentationId);
		movimentation.setId(id);
		movimentations.add(movimentation);
	}
	
	public static void editMovimentation(String movimentationType, Movimentation movimentation) {
		Set<Movimentation> movimentations = movimentationType.equals("income") ?
				FakeBD.incomes :
				FakeBD.outcomes;
		movimentations.add(movimentation);
	}
	
	public static Movimentation getMovimentation(String movimentationType, String id) {
		Set<Movimentation> movimentations = movimentationType == "income" ?
				FakeBD.incomes :
				FakeBD.outcomes;
		
		for (Movimentation movimentation : movimentations) {
			if (movimentation.getId().equals(id)) return movimentation;
		}
		
		return null;
	}
}
