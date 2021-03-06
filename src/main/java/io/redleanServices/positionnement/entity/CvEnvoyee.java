package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class CvEnvoyee implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idcv;
	private Date dateEnvoi ;
	private String PartenairClient ;
	private String NomSociete;
	private float TJM ;
	private String remarques;
	private String Statut;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CVENVOYE_CONTACT",
            joinColumns = {
                    @JoinColumn(name = "CVENVOYE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CONTACT_ID")
            }
    )
    private Set<Contact> contact = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	
	public CvEnvoyee() {
	}
	
	public CvEnvoyee(Long idcv, Date dateEnvoi, String partenairClient, String nomSociete, float tJM, String remarques,
			String statut, Set<Contact> contact) {
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
	public CvEnvoyee(Date dateEnvoi, String partenairClient, String nomSociete, float tJM, String remarques,
			String statut) {
		this.dateEnvoi = dateEnvoi;
		PartenairClient = partenairClient;
		NomSociete = nomSociete;
		TJM = tJM;
		this.remarques = remarques;
		Statut = statut;
	}

	public CvEnvoyee(Long idcv, Date dateEnvoi, String partenairClient, String nomSociete, float tJM, String remarques,
			String statut) {
		super();
		this.idcv = idcv;
		this.dateEnvoi = dateEnvoi;
		PartenairClient = partenairClient;
		NomSociete = nomSociete;
		TJM = tJM;
		this.remarques = remarques;
		Statut = statut;
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact.add(contact);
	}
	public void setManyContact(Set<Contact> contact) {
		this.contact = contact;
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

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}
	
	 
	 
	 

}
