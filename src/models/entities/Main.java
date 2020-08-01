package models.entities;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import Mock.FakeBD;
import controller.IncomeController;

public class Main {

	public static void main(String[] args) throws ParseException {
		Map<String, String> fields = new HashMap();
		fields.put("name", "Teste 1");
		fields.put("value", "3000");
		fields.put("date", "01/08/2020");
		fields.put("account", "1");
		
		IncomeController.create(fields);
	}

}
