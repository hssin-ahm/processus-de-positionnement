package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Briefing;


@Repository
public interface BriefingRepository  extends JpaRepository<Briefing,Long>  {

}
