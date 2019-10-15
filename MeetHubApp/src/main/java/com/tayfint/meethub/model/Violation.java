package com.tayfint.meethub.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "app_violation")
@EntityListeners(AuditingEntityListener.class)
public class Violation extends BaseEntity implements Auditable {

	@Column(name = "membership_id")
	private Long membership_id;
	
	@Column(name = "violation_type_id")
	private Long violation_type_id;
	
	@Column(name = "description", length = 1500)
	private String description;
	
	@Embedded
	private Audit audit;

	public Long getMembership_id() {
		return membership_id;
	}

	public void setMembership_id(Long membership_id) {
		this.membership_id = membership_id;
	}

	public Long getViolation_type_id() {
		return violation_type_id;
	}

	public void setViolation_type_id(Long violation_type_id) {
		this.violation_type_id = violation_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Violation [getMembership_id()=" + getMembership_id() + ", getViolation_type_id()="
				+ getViolation_type_id() + ", getDescription()=" + getDescription() + ", getId()=" + getId() + "]";
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
