package com.tayfint.meethub.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Long, Role>  implements RoleDao {

	@Override
	public Role findByRole(String role) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("role", role));
		return (Role) crit.uniqueResult();
	}

}
