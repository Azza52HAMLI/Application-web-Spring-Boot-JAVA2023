package org.azza.ReservationGL.Persistance;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numero;
	@CreationTimestamp
	private LocalDate date ;
	private boolean etat;
	private Double montant;
	public Facture() {
		super();
	}
	public Facture(long numero, LocalDate date, boolean etat, Double montant) {
		super();
		this.numero = numero;
		this.date = date;
		this.etat = etat;
		this.montant = montant;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Facture [numero=" + numero + ", date=" + date + ", etat=" + etat + ", montant=" + montant + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, etat, montant, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		return Objects.equals(date, other.date) && etat == other.etat && Objects.equals(montant, other.montant)
				&& numero == other.numero;
	}
	
	
	
	
	
	
	
	

}
