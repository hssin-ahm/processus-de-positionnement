package io.redleanServices.positionnement.service;

import io.redleanServices.positionnement.dao.RoleDao;
import io.redleanServices.positionnement.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private RoleDao roleDao;
	@Override
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
