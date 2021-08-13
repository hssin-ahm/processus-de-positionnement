package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestTechniqueClient implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTestTechniqueClient;
	private String TypeEntretien ;
	private Date dateEntretien;
	private String observations;
	
	public TestTechniqueClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestTechniqueClient(Long idtestTechniqueClient, String typeEntretien, Date dateEntretien,
			String observations) {
		super();
		idTestTechniqueClient = idtestTechniqueClient;
		TypeEntretien = typeEntretien;
		this.dateEntretien = dateEntretien;
		this.observations = observations;
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
