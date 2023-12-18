package org.azza.ReservationGL.Persistance;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Demandeur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code  ;
	private String nom;
	private String adresse;
	
	
	public Demandeur() {
		super();
	}


	public Demandeur(long code, String nom, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}


	public long getCode() {
		return code;
	}


	public void setCode(long code) {
		this.code = code;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adresse, code, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demandeur other = (Demandeur) obj;
		return Objects.equals(adresse, other.adresse) && code == other.code && Objects.equals(nom, other.nom);
	}


	@Override
	public String toString() {
		return "Demandeur [code=" + code + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
	
	

}
