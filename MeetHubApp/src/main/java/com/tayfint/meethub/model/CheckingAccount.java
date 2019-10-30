package com.tayfint.meethub.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHK")
public class CheckingAccount extends Account {

	private static final long serialVersionUID = 1L;
	
}
