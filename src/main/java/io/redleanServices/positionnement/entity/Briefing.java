package io.redleanServices.positionnement.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Briefing implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idBriefing;
	private Date dateBriefing;
	private String type;
	private String dure;
	private  String remarque;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "BRIEFING_CONTACT",
            joinColumns = {
                    @JoinColumn(name = "BRIEFING_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CONTACT_ID")
            }
    )
    private Set<Contact> contact = new HashSet<>();
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;

	@JsonIgnore
	@OneToOne
    @JoinColumn(name = "cv_envoyee_id")
	private CvEnvoyee cvEnvoyee;
    
	public Briefing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	 


	public Briefing(Long idBriefing, Date dateBriefing, String type, String dure, String remarque, Set<Contact> contact,
			Consultant consultant, CvEnvoyee cvEnvoyee) {
		super();
		this.idBriefing = idBriefing;
		this.dateBriefing = dateBriefing;
		this.type = type;
		this.dure = dure;
		this.remarque = remarque;
		this.contact = contact;
		this.consultant = consultant;
		this.cvEnvoyee = cvEnvoyee;
	}






	public CvEnvoyee getCvEnvoyee() {
		return cvEnvoyee;
	}






	public void setCvEnvoyee(CvEnvoyee cvEnvoyee) {
		this.cvEnvoyee = cvEnvoyee;
	}






	public void setManyContact(Set<Contact> contact) {
		this.contact = contact;
	}
	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
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
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
    
	  
	
	
}
