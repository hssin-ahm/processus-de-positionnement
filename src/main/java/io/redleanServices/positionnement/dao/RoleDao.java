package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {

	Role findByRoleName(String roleName);

}
