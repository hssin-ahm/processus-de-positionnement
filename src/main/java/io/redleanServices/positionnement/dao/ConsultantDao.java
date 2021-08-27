package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.redleanServices.positionnement.entity.Consultant;

import java.util.List;
import java.util.Optional;

public interface ConsultantDao extends JpaRepository<Consultant, Long> {
    void deleteEmployeeById(Long id);

    Optional<Consultant> findConsultantById(Long id);

    
    @Query(value = "SELECT * FROM consultant c WHERE c.mail LIKE %?1% \n"
    		+ "    or  c.nom LIKE %?1%\n"
    		+ "    or  c.prenom LIKE %?1%\n"
    		+ "    or  c.statut LIKE %?1%\n"
    		+ "    or  c.title LIKE %?1%\n"
    		+ "    or  c.seniorite LIKE %?1%", 
    		  nativeQuery = true)
	List<Consultant> cherchebyKeyWord(String keyword);

	
    
}
