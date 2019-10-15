package com.tayfint.meethub.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "app_setting")
@EntityListeners(AuditingEntityListener.class)
public class Setting extends BaseEntity implements Auditable {
	
	@Column(name= "CODE", length=3)
	private String code;
	
	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCRIPTION", length = 1500)
	private String description;
	
	@Column(name = "DEFAULT_VALUE")
	private String value;

	@Embedded
	private Audit audit;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Setting [getName()=" + getName() + ", getCode()=" + getCode() + ", getDescription()=" + getDescription()
				+ ", getValue()=" + getValue() + ", getId()=" + getId() + "]";
	}

	@Override
	public Audit getAudit() {
		return audit;
	}

	@Override
	public void setAudit(Audit audit) {
		this.audit = audit;		
	}
	
}
