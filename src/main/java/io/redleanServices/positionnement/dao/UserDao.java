package io.redleanServices.positionnement.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	User findByUserName(String username);
	void deleteByUserName(String username);
}
