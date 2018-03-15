package com.tayfint.meethub.model;

import java.sql.Blob;
import java.util.Date;
import java.util.Set;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "app_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UserTab")
	@TableGenerator(name = "UserTab", table = "hibernate_id", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "USER_GEN", allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USERNAME", nullable = false, length = 50)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "FAILED_LOGIN_ATTEMPTS")
	private Short failedLoginAttempts;
	
	@Column(name = "LAST_SUCCESSFUL_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSuccessfulLogin;
	
	@Column(name = "BLOCKED_UNTIL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date blockedUntil;
	
	@Column(name = "IS_DECEASED")
	private Boolean isDeceased;
	
	@Column(name = "PRIMARY_ID", length = 40)
	private String primaryId;
	
	@Column(name = "PRIMARY_ID_TYPE", length = 45)
	private String primaryIdType;
	
	@Column(name = "BIRTHDATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 45)
	private String firstName;
	
	@Column(name = "MIDDLE_NAME", length = 45)
	private String middleName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 45)
	private String lastName;
	
	@Column(name = "MAIDEN_NAME", length = 45)
	private String maidenName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "EDUCATION", length = 45)
	private String education;
	
	@Column(name = "OCCUPATION", length = 45)
	private String occupation;
	
	@Column(name = "MONTHLY_SALARY", precision = 22, scale = 0)
	private Double monthlySalary;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name = "MARITAL_STATUS_CD", length = 3)
	private String maritalStatusCd;
	
	@Column(name = "EMPLOYMENT_STATUS_CD", length = 3)
	private String employmentStatusCd;
	
	@Column(name = "EMPLOYER", length = 100)
	private String employer;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "CITIZENSHIP", length = 45)
	private String citizenship;
	
	@Column(name = "NAME_SUFFIX", length = 45)
	private String nameSuffix;
	
	@Column(name = "NAME_PREFIX", length = 45)
	private String namePrefix;
	
	@Column(name = "ROW_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date rowUpdateDate = new Date(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "EMAIL", length = 45)
	private String email;
	
	@Column(name = "PICTURE")
	@Lob
	private Blob picture;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "app_user_role", 
				joinColumns = { @JoinColumn(name = "USER_ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles;

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getFailedLoginAttempts() {
		return this.failedLoginAttempts;
	}

	public void setFailedLoginAttempts(Short failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public Date getLastSuccessfulLogin() {
		return this.lastSuccessfulLogin;
	}

	public void setLastSuccessfulLogin(Date lastSuccessfulLogin) {
		this.lastSuccessfulLogin = lastSuccessfulLogin;
	}

	public Date getBlockedUntil() {
		return this.blockedUntil;
	}

	public void setBlockedUntil(Date blockedUntil) {
		this.blockedUntil = blockedUntil;
	}

	public Boolean getIsDeceased() {
		return this.isDeceased;
	}

	public void setIsDeceased(Boolean isDeceased) {
		this.isDeceased = isDeceased;
	}

	public String getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getPrimaryIdType() {
		return this.primaryIdType;
	}

	public void setPrimaryIdType(String primaryIdType) {
		this.primaryIdType = primaryIdType;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenName() {
		return this.maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Double getMonthlySalary() {
		return this.monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getMaritalStatusCd() {
		return this.maritalStatusCd;
	}

	public void setMaritalStatusCd(String maritalStatusCd) {
		this.maritalStatusCd = maritalStatusCd;
	}

	public String getEmploymentStatusCd() {
		return this.employmentStatusCd;
	}

	public void setEmploymentStatusCd(String employmentStatusCd) {
		this.employmentStatusCd = employmentStatusCd;
	}

	public String getEmployer() {
		return this.employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getNamePrefix() {
		return this.namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public Date getRowUpdateDate() {
		return this.rowUpdateDate;
	}

	public void setRowUpdateDate(Date rowUpdateDate) {
		this.rowUpdateDate = rowUpdateDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Transient
	public boolean isNew() {
		return (this.userId == null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primaryId == null) ? 0 : primaryId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (primaryId == null) {
			if (other.primaryId != null)
				return false;
		} else if (!primaryId.equals(other.primaryId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
