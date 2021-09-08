package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestTechniqueClient implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTestTechniqueClient;
	private String TypeEntretien ;
	private String dure;
	private Date dateEntretien;
	private String observations;
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	public TestTechniqueClient() {
		super();
	}
	
	

	public Consultant getConsultant() {
		return consultant;
	}



	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}



	public TestTechniqueClient(Long idTestTechniqueClient, String typeEntretien, String dure, Date dateEntretien,
			String observations, Consultant consultant) {
		super();
		this.idTestTechniqueClient = idTestTechniqueClient;
		TypeEntretien = typeEntretien;
		this.dure = dure;
		this.dateEntretien = dateEntretien;
		this.observations = observations;
		this.consultant = consultant;
	}



	public Long getIdTestTechniqueClient() {
		return idTestTechniqueClient;
	}

	public void setIdTestTechniqueClient(Long idTestTechniqueClient) {
		this.idTestTechniqueClient = idTestTechniqueClient;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	public Long getTestTechniqueClient() {
		return idTestTechniqueClient;
	}
	public void setTestTechniqueClient(Long idtestTechniqueClient) {
		idTestTechniqueClient = idtestTechniqueClient;
	}
	public String getTypeEntretien() {
		return TypeEntretien;
	}
	public void setTypeEntretien(String typeEntretien) {
		TypeEntretien = typeEntretien;
	}
	public Date getDateEntretien() {
		return dateEntretien;
	}
	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}
	
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	


}
