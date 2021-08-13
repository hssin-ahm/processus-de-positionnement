package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.client;

@Repository
public interface ClientRepository  extends JpaRepository<client,Long> {

}
