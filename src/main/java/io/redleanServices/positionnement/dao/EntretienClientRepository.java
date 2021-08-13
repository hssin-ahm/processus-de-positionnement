package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.EntretienClient;


@Repository
public interface EntretienClientRepository extends JpaRepository<EntretienClient,Long>{

}
