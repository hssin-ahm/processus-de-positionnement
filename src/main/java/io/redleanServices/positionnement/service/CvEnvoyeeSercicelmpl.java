package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.CvEnvoyeeRepository;
import io.redleanServices.positionnement.entity.CvEnvoyee;

@Service
public class CvEnvoyeeSercicelmpl implements CvEnvoyeeService {
	@Autowired
	CvEnvoyeeRepository cvEnvoyeeRepository;
	@Override
	public CvEnvoyee saveCvEnvoyee(CvEnvoyee ec) {
		return cvEnvoyeeRepository.save(ec);

	}

	@Override
	public void deleteCvEnvoyee(CvEnvoyee ec) {
		// TODO Auto-generated method stub
		cvEnvoyeeRepository.delete(ec);		

		
	}

	@Override
	public void deleteCvEnvoyeeById(Long id) {
		// TODO Auto-generated method stub
		cvEnvoyeeRepository.deleteById(id);

		
	}

	@Override
	public CvEnvoyee getCvEnvoyee(Long id) {
		return cvEnvoyeeRepository.findById(id).get();

	}

	@Override
	public List<CvEnvoyee> getAllCvEnvoyees() {
		List<CvEnvoyee> Categorys =(List<CvEnvoyee>) cvEnvoyeeRepository.findAll();
		for(CvEnvoyee Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public CvEnvoyee updateCvEnvoyee(CvEnvoyee adv, Long idAd) {
		CvEnvoyee a = adv;
		return cvEnvoyeeRepository.save(a);
	}

	@Override
	public CvEnvoyee updateCvEnvoyee(CvEnvoyee p) {
		return cvEnvoyeeRepository.save(p);

	}

}
