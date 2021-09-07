package io.redleanServices.positionnement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Contact  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idContact;
	@Column(length = 45, nullable = false, unique = true)
	private String nom ;
	@Column(length = 45, nullable = false, unique = true)
	private String prenom;
	private String mail ;
	private String poste ;
	private Long  telephone  ;
	
	public Long getIdContact() {
		return idContact;
	}
	public void setIdContact(Long idContact) {
		this.idContact = idContact;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	public Contact(Long idContact, String nom, String prenom, String mail, String poste, Long telephone) {
		super();
		this.idContact = idContact;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.poste = poste;
		this.telephone = telephone;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}