package io.redleanServices.positionnement.entity;

import java.util.Date;
import java.util.Set;

public class CvEnvoyeContact {
	private Long idcv;
	private Date dateEnvoi ;
	private String PartenairClient ;
	private String NomSociete;
	private float TJM ;
	private String remarques;
	private String Statut;
	private Set<Contact> contact ;
	private Consultant consultant;
	public CvEnvoyeContact(Long idcv, Date dateEnvoi, String partenairClient, String nomSociete, float tJM,
			String remarques, String statut, Set<Contact> contact) {
		super();
		this.idcv = idcv;
		this.dateEnvoi = dateEnvoi;
		PartenairClient = partenairClient;
		NomSociete = nomSociete;
		TJM = tJM;
		this.remarques = remarques;
		Statut = statut;
		this.contact = contact;
	}
	
	public CvEnvoyeContact(Long idcv, Date dateEnvoi, String partenairClient, String nomSociete, float tJM,
			String remarques, String statut, Set<Contact> contact, Consultant consultant) {
		super();
		this.idcv = idcv;
		this.dateEnvoi = dateEnvoi;
		PartenairClient = partenairClient;
		NomSociete = nomSociete;
		TJM = tJM;
		this.remarques = remarques;
		Statut = statut;
		this.contact = contact;
		this.consultant = consultant;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public CvEnvoyeContact() {
		super();
	}
	public Long getIdcv() {
		return idcv;
	}
	public void setIdcv(Long idcv) {
		this.idcv = idcv;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public String getPartenairClient() {
		return PartenairClient;
	}
	public void setPartenairClient(String partenairClient) {
		PartenairClient = partenairClient;
	}
	public String getNomSociete() {
		return NomSociete;
	}
	public void setNomSociete(String nomSociete) {
		NomSociete = nomSociete;
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
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public Set<Contact> getContact() {
		return contact;
	}
	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}
	
}
