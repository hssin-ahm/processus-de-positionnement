package io.redleanServices.positionnement.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Briefing implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idBriefing;
	private Date dateBriefing;
	private String lieu;
    @ManyToOne()
	private Contact   contact ;
	private  String remarque;
    private String Statut;
	public Briefing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Briefing(Long idBriefing, Date dateBriefing, String lieu, Contact contact,
			String remarque, String statut) {
		super();
		this.idBriefing = idBriefing;
		this.dateBriefing = dateBriefing;
		this.lieu = lieu;
		this.contact = contact;
		this.remarque = remarque;
		Statut = statut;
	}
	public Long getIdBriefing() {
		return idBriefing;
	}
	public void setIdBriefing(Long idBriefing) {
		this.idBriefing = idBriefing;
	}
	public Date getDateBriefing() {
		return dateBriefing;
	}
	public void setDateBriefing(Date dateBriefing) {
		this.dateBriefing = dateBriefing;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
    
	  
	
	
}
