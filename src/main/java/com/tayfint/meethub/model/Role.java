package com.tayfint.meethub.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "app_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UserPRFTab")
	@TableGenerator(name = "UserPRFTab", 
					table = "hibernate_id", 
					pkColumnName = "GEN_KEY", 
					valueColumnName = "GEN_VALUE", 
					pkColumnValue = "USER_PRF_GEN", 
					allocationSize = 1)
	@Column(name = "role_id")
	private long id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public Set<User> getUsers() {
		return users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Authority [getId()=" + getId() + ", getRole()=" + getRole() + "]";
	}


}
