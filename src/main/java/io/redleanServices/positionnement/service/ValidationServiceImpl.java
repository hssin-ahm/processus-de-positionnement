package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.ValidationRepository;
import io.redleanServices.positionnement.entity.Validation;

@Service 
public class ValidationServiceImpl implements ValidationService{
	@Autowired
	ValidationRepository  validationRepository;
	@Override
	public Validation saveValidation(Validation v) {
		return validationRepository.save(v);

	}

	@Override
	public void deleteValidation(Validation p) {
		validationRepository.delete(p);
		
	}

	@Override
	public void deleteValidationById(Long id) {
		// TODO Auto-generated method stub
		validationRepository.deleteById(id);

		
	}

	@Override
	public Validation getValidation(Long id) {
		return validationRepository.findById(id).get();

	}

	@Override
	public List<Validation> getAllValidations() {
		List<Validation> Categorys =(List<Validation>) validationRepository.findAll();
		for(Validation Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public Validation updateValidation(Validation adv, Long idAd) {
		Validation a = adv;
		return validationRepository.save(adv);
	}

	@Override
	public Validation updateValidation(Validation p) {
		return validationRepository.save(p);

	}

}
