package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Validation;


public interface ValidationService {
        	Validation saveValidation(Validation v);
			void deleteValidation(Validation p);
			void deleteValidationById(Long id);
			Validation getValidation(Long id);
			List<Validation> getAllValidations();
			Validation updateValidation(Validation adv, Long idAd) ;
			Validation updateValidation(Validation p) ;
}
