package controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import Mock.FakeBD;
import models.entities.Income;

public class IncomeController {

    public static void create(Map<String, String> fields) throws ParseException {
        String name       = fields.get("name");
        String value      = fields.get("value");
        String dateString = fields.get("date");
        String accountId  = fields.get("account");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(dateString);

        Income income = new Income(name, new BigDecimal(value), date, accountId);
        FakeBD.incomes.add(income);
    }
}