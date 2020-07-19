package models.entities;

import java.math.BigDecimal;
import java.util.UUID;

import models.entities.enums.Types;

public class Account {
	private UUID id;
	private String name;
	private Types type;
	private BigDecimal amount;
	private String description;
	//private List<Movimentation> movimentations = new ArrayList<Movimentation>();
	
	public Account(String name, Types type, BigDecimal amount, String description) {
		this.id = UUID.randomUUID();
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
	
	/*private void addNewMovimentation(Movimentation movimentation) {
		movimentations.add(movimentation);
	}
	
	public void addRevenue(BigDecimal amount) {
		Movimentation movimentation;
	}*/
}
