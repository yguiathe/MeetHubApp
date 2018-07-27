package com.tayfint.meethub.model;

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tayfint.meethub.model.security.Authority;
import com.tayfint.meethub.model.security.UserRole;

@Entity
@Table(name = "app_user")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@DateTimeFormat(iso = ISO.DATE)
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
	private Boolean enabled = true;

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Membership> memberships;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();

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

	public Date getBirthdate() {
		return this.birthdate;
	}

	public Date getBlockedUntil() {
		return this.blockedUntil;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public String getEducation() {
		return this.education;
	}

	public String getEmail() {
		return email;
	}

	public String getEmployer() {
		return this.employer;
	}

	public String getEmploymentStatusCd() {
		return this.employmentStatusCd;
	}

	public Short getFailedLoginAttempts() {
		return this.failedLoginAttempts;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public Boolean getIsDeceased() {
		return this.isDeceased;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Date getLastSuccessfulLogin() {
		return this.lastSuccessfulLogin;
	}

	public String getMaidenName() {
		return this.maidenName;
	}

	public String getMaritalStatusCd() {
		return this.maritalStatusCd;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public Double getMonthlySalary() {
		return this.monthlySalary;
	}

	public String getNamePrefix() {
		return this.namePrefix;
	}

	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public String getPassword() {
		return this.password;
	}

	public Blob getPicture() {
		return picture;
	}

	public String getPrimaryId() {
		return this.primaryId;
	}

	public String getPrimaryIdType() {
		return this.primaryIdType;
	}

	public Date getRowUpdateDate() {
		return this.rowUpdateDate;
	}

	public Long getUserId() {
		return this.userId;
	}

	public Set<Membership> getMemberships() {
		return memberships;
	}

	public String getUsername() {
		return this.username;
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

	@Transient
	public boolean isNew() {
		return (this.userId == null);
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setBlockedUntil(Date blockedUntil) {
		this.blockedUntil = blockedUntil;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public void setEmploymentStatusCd(String employmentStatusCd) {
		this.employmentStatusCd = employmentStatusCd;
	}

	public void setFailedLoginAttempts(Short failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setIsDeceased(Boolean isDeceased) {
		this.isDeceased = isDeceased;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastSuccessfulLogin(Date lastSuccessfulLogin) {
		this.lastSuccessfulLogin = lastSuccessfulLogin;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public void setMaritalStatusCd(String maritalStatusCd) {
		this.maritalStatusCd = maritalStatusCd;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public void setPrimaryIdType(String primaryIdType) {
		this.primaryIdType = primaryIdType;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setRowUpdateDate(Date rowUpdateDate) {
		this.rowUpdateDate = rowUpdateDate;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setMemberships(Set<Membership> memberships) {
		this.memberships = memberships;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender
				+ ", education=" + education + ", monthlySalary=" + monthlySalary + ", maritalStatusCd="
				+ maritalStatusCd + ", email=" + email + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (UserRole ur : userRoles) {
			authorities.add(new Authority(ur.getRole().getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
