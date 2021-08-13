package io.redleanServices.positionnement.service;

import java.util.List;

import io.redleanServices.positionnement.entity.Briefing;


public interface BriefingService {
	Briefing saveBriefing(Briefing b);
	void deleteBriefing(Briefing b);
	void deleteBriefingById(Long id);
	Briefing getBriefing(Long id);
	List<Briefing> getAllBriefings();
	Briefing updateBriefing(Briefing adv, Long idAd) ;
	Briefing updateBriefing(Briefing p) ;
}
