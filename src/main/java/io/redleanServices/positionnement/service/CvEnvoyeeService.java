package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.CvEnvoyee;


public interface CvEnvoyeeService {
	CvEnvoyee saveCvEnvoyee(CvEnvoyee ec);
	void deleteCvEnvoyee(CvEnvoyee ec);
	void deleteCvEnvoyeeById(Long id);
	CvEnvoyee getCvEnvoyee(Long id);
	List<CvEnvoyee> getAllCvEnvoyees();
	CvEnvoyee updateCvEnvoyee(CvEnvoyee adv, Long idAd) ;
	CvEnvoyee updateCvEnvoyee(CvEnvoyee p) ;

}
