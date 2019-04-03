package com.tayfint.meethub.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@DiscriminatorValue("CHK")
public class CheckingAccount extends Account {
	
}
