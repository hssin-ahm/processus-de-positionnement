package io.redleanServices.positionnement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import io.redleanServices.positionnement.entity.Contact;


@Repository
public interface ContactRepository  extends JpaRepository<Contact,Long> {

}
