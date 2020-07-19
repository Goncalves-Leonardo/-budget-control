package models.entities;

import java.math.BigDecimal;
import java.util.Date;

import models.entities.enums.Tag;

public interface Movimentation {
	public String getName();
	public BigDecimal getValue();
	public Date getDate();
	public Tag[] getTags();
}
