package io.redleanServices.positionnement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Consultant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String prenom;
    private String nom;
    private String title;
    private Date disponibilite;
    private String statut;
    private String Mobilite;
    private String Seniorite;
    private long numTel;
    private String mail;
    private String niveauAnglais;
    private String niveauFrancais;
    @Column(nullable = false, updatable = false)
    private String consultantCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant", fetch = FetchType.LAZY)
    private List<Positionnement> positionnements;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant", fetch = FetchType.LAZY)
    private List<CvEnvoyee> cvEnvoye;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant", fetch = FetchType.LAZY)
    private List<EntretienPartenaire> entretienPartenaires;
    
    public Consultant() {}

	public Consultant(String prenom, String nom, String title, Date disponibilite, String statut, String mobilite,
			String seniorite, long numTel, String mail, String niveauAnglais, String niveauFrancais,
			String consultantCode) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.title = title;
		this.disponibilite = disponibilite;
		this.statut = statut;
		Mobilite = mobilite;
		Seniorite = seniorite;
		this.numTel = numTel;
		this.mail = mail;
		this.niveauAnglais = niveauAnglais;
		this.niveauFrancais = niveauFrancais;
		this.consultantCode = consultantCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Date disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getMobilite() {
		return Mobilite;
	}

	public void setMobilite(String mobilite) {
		Mobilite = mobilite;
	}

	public String getSeniorite() {
		return Seniorite;
	}

	public void setSeniorite(String seniorite) {
		Seniorite = seniorite;
	}

	public long getNumTel() {
		return numTel;
	}

	public void setNumTel(long numTel) {
		this.numTel = numTel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNiveauAnglais() {
		return niveauAnglais;
	}

	public void setNiveauAnglais(String niveauAnglais) {
		this.niveauAnglais = niveauAnglais;
	}

	public String getNiveauFrancais() {
		return niveauFrancais;
	}

	public void setNiveauFrancais(String niveauFrancais) {
		this.niveauFrancais = niveauFrancais;
	}

	public String getConsultantCode() {
		return consultantCode;
	}

	public void setConsultantCode(String consultantCode) {
		this.consultantCode = consultantCode;
	}

    
   
}
