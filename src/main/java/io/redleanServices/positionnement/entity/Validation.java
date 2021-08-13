package io.redleanServices.positionnement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Validation  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idValidation;
	private String Feedback ; 
	private String DemarrageMission ;
	private String MesuresTeletravail ;
	public Validation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Validation(Long idValidation, String feedback, String demarrageMission, String mesuresTeletravail) {
		super();
		this.idValidation = idValidation;
		Feedback = feedback;
		DemarrageMission = demarrageMission;
		MesuresTeletravail = mesuresTeletravail;
	}
	public Long getIdValidation() {
		return idValidation;
	}
	public void setIdValidation(Long idValidation) {
		this.idValidation = idValidation;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	public String getDemarrageMission() {
		return DemarrageMission;
	}
	public void setDemarrageMission(String demarrageMission) {
		DemarrageMission = demarrageMission;
	}
	public String getMesuresTeletravail() {
		return MesuresTeletravail;
	}
	public void setMesuresTeletravail(String mesuresTeletravail) {
		MesuresTeletravail = mesuresTeletravail;
	}
	

}
