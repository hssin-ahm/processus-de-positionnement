package io.redleanServices.positionnement.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Consultant;
import io.redleanServices.positionnement.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	User findByUserName(String username);
	void deleteByUserName(String username);
	@Query(value = "SELECT * FROM user c WHERE c.user_name LIKE %?1% \n"
    		+ "    or  c.user_last_name LIKE %?1%\n"
    		+ "    or  c.user_first_name LIKE %?1%\n"
    		+ "    or  c.email LIKE %?1%\n", 
    		  nativeQuery = true)
	List<User> cherchebyKeyWord(String keyword);
}
