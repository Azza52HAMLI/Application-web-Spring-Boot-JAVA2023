package org.azza.ReservationGL.Persistance;



import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long numReservation;
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Salle salle;
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private PlageHoraire ph;
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Facture fact;
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Demandeur demendeur;
	public Reservation() {
		super();
	}
	
	
	public static double calculPrixLocation(float surface, LocalTime heurDebut, LocalTime heurFin) {
  
       
        long duree = Math.abs(ChronoUnit.HOURS.between(heurDebut, heurFin));  
        float prixHeure=35;
        double tarif = duree * prixHeure;
        
        if(Float.compare(surface, 500f) >= 0) {
        	tarif = tarif * 1.2;
        }
        else
        {
        	tarif = tarif*0.8;
        	
        }
        return tarif;
        

    }
	public Reservation(long numReservation, Salle salle, PlageHoraire ph, Facture fact, Demandeur demendeur) {
		super();
		this.numReservation = numReservation;
		this.salle = salle;
		this.ph = ph;
		this.fact = fact;
		this.demendeur = demendeur;
	}
	public long getNumReservation() {
		return numReservation;
	}
	public void setNumReservation(long numReservation) {
		this.numReservation = numReservation;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public PlageHoraire getPh() {
		return ph;
	}
	public void setPh(PlageHoraire ph) {
		this.ph = ph;
	}
	public Facture getFact() {
		return fact;
	}
	public void setFact(Facture fact) {
		this.fact = fact;
	}
	public Demandeur getDemendeur() {
		return demendeur;
	}
	public void setDemendeur(Demandeur demendeur) {
		this.demendeur = demendeur;
	}
	
	
	
	
	
	

}
