package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class client  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idclient;
	private String Nom ;
	private  String prenom ;
	private Date Datedenvoi;
	private String  Secteuractivite;
	private Date DureMission;
	private String LieuMission;
	private String Intituleposte ;
	private String Descriptif ;
	private float TJM;
	private String remarques ;
	public client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public client(Long idclient, String nom, String prenom, Date datedenvoi, String secteuractivite, Date dureMission,
			String lieuMission, String intituleposte, String descriptif, float tJM, String remarques) {
		super();
		this.idclient = idclient;
		Nom = nom;
		this.prenom = prenom;
		Datedenvoi = datedenvoi;
		Secteuractivite = secteuractivite;
		DureMission = dureMission;
		LieuMission = lieuMission;
		Intituleposte = intituleposte;
		Descriptif = descriptif;
		TJM = tJM;
		this.remarques = remarques;
	}
	public Long getIdclient() {
		return idclient;
	}
	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDatedenvoi() {
		return Datedenvoi;
	}
	public void setDatedenvoi(Date datedenvoi) {
		Datedenvoi = datedenvoi;
	}
	public String getSecteuractivite() {
		return Secteuractivite;
	}
	public void setSecteuractivite(String secteuractivite) {
		Secteuractivite = secteuractivite;
	}
	public Date getDureMission() {
		return DureMission;
	}
	public void setDureMission(Date dureMission) {
		DureMission = dureMission;
	}
	public String getLieuMission() {
		return LieuMission;
	}
	public void setLieuMission(String lieuMission) {
		LieuMission = lieuMission;
	}
	public String getIntituleposte() {
		return Intituleposte;
	}
	public void setIntituleposte(String intituleposte) {
		Intituleposte = intituleposte;
	}
	public String getDescriptif() {
		return Descriptif;
	}
	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}
	public float getTJM() {
		return TJM;
	}
	public void setTJM(float tJM) {
		TJM = tJM;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	

}
