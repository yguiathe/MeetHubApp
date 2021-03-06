package com.tayfint.meethub.model.security;

import javax.persistence.*;

import com.tayfint.meethub.model.User;

@Entity
@Table(name = "app_user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UserPRFTab")
	@TableGenerator(name = "UserPRFTab", 
					table = "hibernate_id", 
					pkColumnName = "GEN_KEY", 
					valueColumnName = "GEN_VALUE", 
					pkColumnValue = "USER_PRF_GEN", 
					allocationSize = 1)
	@Column(name = "id")
    private long userRoleId;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {}

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
