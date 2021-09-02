package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Positionnement implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPositionnement;
	
	private Date date;
	private String nomDuClient;
	private String SecteurActivite;
	private String duredeLaMission; 
	private String intituleDuPoste; 
	private String descriptifDeLaMission ;
	private  float TJM ;
	private String remarque;
	
	@ManyToOne
	private Consultant consultant;
	
	public Positionnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Positionnement(Long idPositionnement, Date date, String nomDuClient, String secteurActivite,
			String duredeLaMission, String intituleDuPoste, String descriptifDeLaMission, float tJM, String remarque,
			Consultant consultant) {
		super();
		this.idPositionnement = idPositionnement;
		this.date = date;
		this.nomDuClient = nomDuClient;
		SecteurActivite = secteurActivite;
		this.duredeLaMission = duredeLaMission;
		this.intituleDuPoste = intituleDuPoste;
		this.descriptifDeLaMission = descriptifDeLaMission;
		TJM = tJM;
		this.remarque = remarque;
		this.consultant = consultant;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getNomDuClient() {
		return nomDuClient;
	}


	public void setNomDuClient(String nomDuClient) {
		this.nomDuClient = nomDuClient;
	}


	public String getSecteurActivite() {
		return SecteurActivite;
	}


	public void setSecteurActivite(String secteurActivite) {
		SecteurActivite = secteurActivite;
	}


	public String getDuredeLaMission() {
		return duredeLaMission;
	}


	public void setDuredeLaMission(String duredeLaMission) {
		this.duredeLaMission = duredeLaMission;
	}


	public String getIntituleDuPoste() {
		return intituleDuPoste;
	}


	public void setIntituleDuPoste(String intituleDuPoste) {
		this.intituleDuPoste = intituleDuPoste;
	}


	public String getDescriptifDeLaMission() {
		return descriptifDeLaMission;
	}


	public void setDescriptifDeLaMission(String descriptifDeLaMission) {
		this.descriptifDeLaMission = descriptifDeLaMission;
	}


	public float getTJM() {
		return TJM;
	}


	public void setTJM(float tJM) {
		TJM = tJM;
	}


	public String getRemarques() {
		return remarque;
	}


	public void setRemarques(String remarque) {
		this.remarque = remarque;
	}


	public Consultant getConsultant() {
		return consultant;
	}


	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}


	public Long getIdPositionnement() {
		return idPositionnement;
	}
	public void setIdPositionnement(Long idPositionnement) {
		this.idPositionnement = idPositionnement;
	}
	
}
