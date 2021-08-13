package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class EntretienClient implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEntretienClient;
	private String TypeEntretienClient;
	private Date dateEntretienClient;
	private float TJM;
	private String remarque;
	private Date duree;
	
	public Long getIdEntretienClient() {
		return idEntretienClient;
	}

	public void setIdEntretienClient(Long idEntretienClient) {
		this.idEntretienClient = idEntretienClient;
	}

	public String getTypeEntretienClient() {
		return TypeEntretienClient;
	}

	public void setTypeEntretienClient(String typeEntretienClient) {
		TypeEntretienClient = typeEntretienClient;
	}

	public Date getDateEntretienClient() {
		return dateEntretienClient;
	}

	public void setDateEntretienClient(Date dateEntretienClient) {
		this.dateEntretienClient = dateEntretienClient;
	}

	public float getTJM() {
		return TJM;
	}

	public void setTJM(float tJM) {
		TJM = tJM;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public EntretienClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntretienClient(Long idEntretienClient, String typeEntretienClient, Date dateEntretienClient, float tJM,
			String remarque, Date duree) {
		super();
		this.idEntretienClient = idEntretienClient;
		TypeEntretienClient = typeEntretienClient;
		this.dateEntretienClient = dateEntretienClient;
		TJM = tJM;
		this.remarque = remarque;
		this.duree = duree;
	}
	

	
}
