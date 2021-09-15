package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Validation  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idValidation;
	private Date date;
	private String Feedback ; 
	private String DemarrageMission ;
	private String MesuresTeletravail ;
	private String remarque;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;

	@JsonIgnore
	@OneToOne
    @JoinColumn(name = "cv_envoyee_id")
	private CvEnvoyee cvEnvoyee;
	
	

	public CvEnvoyee getCvEnvoyee() {
		return cvEnvoyee;
	}

	public void setCvEnvoyee(CvEnvoyee cvEnvoyee) {
		this.cvEnvoyee = cvEnvoyee;
	}

	public Validation(Long idValidation, Date date, String feedback, String demarrageMission, String mesuresTeletravail,
			String remarque, Consultant consultant, CvEnvoyee cvEnvoyee) {
		super();
		this.idValidation = idValidation;
		this.date = date;
		Feedback = feedback;
		DemarrageMission = demarrageMission;
		MesuresTeletravail = mesuresTeletravail;
		this.remarque = remarque;
		this.consultant = consultant;
		this.cvEnvoyee = cvEnvoyee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public Validation() {
		super();
		// TODO Auto-generated constructor stub
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
