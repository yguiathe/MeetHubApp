package com.tayfint.meethub.model;
// default package
// Generated Apr 3, 2018 7:09:29 PM by Hibernate Tools 5.2.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * AppMeeting generated by hbm2java
 */
@Entity
@Table(name = "app_meeting", catalog = "meethub_db", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Meeting implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5765490808528161934L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MeetingTab")
	@TableGenerator(name = "MeetingTab", table = "hibernate_id", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "MTG_GEN", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME", unique = true, length = 45)
	private String name;
	
	@Column(name = "SHORT_DESC", length = 300)
	private String shortDesc;
	
	@Column(name = "LOGO")
	private byte[] logo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createDate = new Date(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSE_DATE", length = 19)
	private Date closeDate;
	
	@Column(name = "TERMS")
	private byte[] terms;
	
	@Column(name = "COUNTRY_OF_INCORP", length = 45)
	private String countryOfIncorp;
	
	@Column(name = "PRIMARY_ID_TYPE", length = 45)
	private String primaryIdType;
	
	@Column(name = "PRIMARY_ID", length = 40)
	private String primaryId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate = new Date(Calendar.getInstance().getTimeInMillis());
	
	@OneToMany(mappedBy = "appMeeting")
	private Set<Membership> appMemberships = new HashSet<Membership>(0);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeting other = (Meeting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primaryId == null) {
			if (other.primaryId != null)
				return false;
		} else if (!primaryId.equals(other.primaryId))
			return false;
		return true;
	}

	public Set<Membership> getAppMemberships() {
		return this.appMemberships;
	}

	public Date getCloseDate() {
		return this.closeDate;
	}

	public String getCountryOfIncorp() {
		return this.countryOfIncorp;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Long getId() {
		return this.id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public String getName() {
		return this.name;
	}

	public String getPrimaryId() {
		return this.primaryId;
	}

	public String getPrimaryIdType() {
		return this.primaryIdType;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public byte[] getTerms() {
		return this.terms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primaryId == null) ? 0 : primaryId.hashCode());
		return result;
	}

	public void setAppMemberships(Set<Membership> appMemberships) {
		this.appMemberships = appMemberships;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public void setCountryOfIncorp(String countryOfIncorp) {
		this.countryOfIncorp = countryOfIncorp;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public void setPrimaryIdType(String primaryIdType) {
		this.primaryIdType = primaryIdType;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public void setTerms(byte[] terms) {
		this.terms = terms;
	}
	
	

}
