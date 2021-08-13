package io.redleanServices.positionnement.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class partenaire implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPartenaire;
	private String  nom;
	private String  prenom;
	private String  post  ;
	private String  Mail  ;
	private Long  telephone  ;
	public partenaire() {
		super();
	
	}
	public partenaire(Long idPartenaire, String nom, String prenom, String post, String mail, Long telephone) {
		super();
		this.idPartenaire = idPartenaire;
		this.nom = nom;
		this.prenom = prenom;
		this.post = post;
		Mail = mail;
		this.telephone = telephone;
	}
	public Long getIdPartenaire() {
		return idPartenaire;
	}
	public void setIdPartenaire(Long idPartenaire) {
		this.idPartenaire = idPartenaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	

	

	
	
	
}
