package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Positionnement implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPositionnement;
	
	private Date date;
	private String nomDuClient;
	private String SecteurActivite;
	private String duredeLaMission; 
	private String lieuDeLaMission;
	private String intituleDuPoste; 
	private String descriptifDeLaMission ;
	private  float TJM ;
	private String remarque;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;

	@JsonIgnore
	@OneToOne
    @JoinColumn(name = "cv_envoyee_id")
	private CvEnvoyee cvEnvoyee;
	
	public Positionnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 


	public Positionnement(Long idPositionnement, Date date, String nomDuClient, String secteurActivite,
			String duredeLaMission, String lieuDeLaMission, String intituleDuPoste, String descriptifDeLaMission,
			float tJM, String remarque, Consultant consultant, CvEnvoyee cvEnvoyee) {
		super();
		this.idPositionnement = idPositionnement;
		this.date = date;
		this.nomDuClient = nomDuClient;
		SecteurActivite = secteurActivite;
		this.duredeLaMission = duredeLaMission;
		this.lieuDeLaMission = lieuDeLaMission;
		this.intituleDuPoste = intituleDuPoste;
		this.descriptifDeLaMission = descriptifDeLaMission;
		TJM = tJM;
		this.remarque = remarque;
		this.consultant = consultant;
		this.cvEnvoyee = cvEnvoyee;
	}



	

	public CvEnvoyee getCvEnvoyee() {
		return cvEnvoyee;
	}





	public void setCvEnvoyee(CvEnvoyee cvEnvoyee) {
		this.cvEnvoyee = cvEnvoyee;
	}





	public String getLieuDeLaMission() {
		return lieuDeLaMission;
	}


	public void setLieuDeLaMission(String lieuDeLaMission) {
		this.lieuDeLaMission = lieuDeLaMission;
	}


	public String getRemarque() {
		return remarque;
	}


	public void setRemarque(String remarque) {
		this.remarque = remarque;
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
