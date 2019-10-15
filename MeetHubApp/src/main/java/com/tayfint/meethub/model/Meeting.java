package com.tayfint.meethub.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "app_meeting")
@EntityListeners(AuditingEntityListener.class)
public class Meeting extends BaseEntity implements Auditable {

	@Column(name = "NAME", unique = true, length = 45)
	private String name;
	
	@Column(name = "SHORT_DESC", length = 1500)
	private String shortDesc;
	
	@Column(name = "LOGO")
	private byte[] logo;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSE_DATE")
	private Date closeDate;
	
	@Embedded
	private Audit audit;
	
	@Column(name = "TERMS")
	private byte[] terms;
	
	@Column(name = "COUNTRY_OF_INCORP", length = 45)
	private String countryOfIncorp;
	
	@Column(name = "PRIMARY_ID_TYPE", length = 45)
	private String primaryIdType;
	
	@Column(name = "PRIMARY_ID", length = 40)
	private String primaryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public byte[] getTerms() {
		return terms;
	}

	public void setTerms(byte[] terms) {
		this.terms = terms;
	}

	public String getCountryOfIncorp() {
		return countryOfIncorp;
	}

	public void setCountryOfIncorp(String countryOfIncorp) {
		this.countryOfIncorp = countryOfIncorp;
	}

	public String getPrimaryIdType() {
		return primaryIdType;
	}

	public void setPrimaryIdType(String primaryIdType) {
		this.primaryIdType = primaryIdType;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
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
