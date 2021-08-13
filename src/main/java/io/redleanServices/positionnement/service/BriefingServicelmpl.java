package io.redleanServices.positionnement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redleanServices.positionnement.dao.BriefingRepository;
import io.redleanServices.positionnement.entity.Briefing;

@Service 
public class BriefingServicelmpl  implements BriefingService{

	
	@Autowired
	BriefingRepository briefingRepository;
	
	@Override
	public Briefing saveBriefing(Briefing b) {
		return briefingRepository.save(b);

	}

	@Override
	public void deleteBriefing(Briefing b) {
		// TODO Auto-generated method stub
		briefingRepository.delete(b);		

	}

	@Override
	public void deleteBriefingById(Long id) {
		// TODO Auto-generated method stub
		briefingRepository.deleteById(id);

		
	}

	@Override
	public Briefing getBriefing(Long id) {
		return briefingRepository.findById(id).get();

	}

	@Override
	public List<Briefing> getAllBriefings() {
		List<Briefing> Categorys =(List<Briefing>) briefingRepository.findAll();
		for(Briefing Category:Categorys) {
			System.out.println(Category);
		}
		return Categorys;
	}

	@Override
	public Briefing updateBriefing(Briefing adv, Long idAd) {
		Briefing a = adv;
		return briefingRepository.save(a);
	}

	@Override
	public Briefing updateBriefing(Briefing p) {
		return briefingRepository.save(p);

	}

}
