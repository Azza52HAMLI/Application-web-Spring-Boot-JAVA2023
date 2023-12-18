package org.azza.ReservationGL.Persistance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class PlageHoraire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
	private LocalDate date;
	private LocalTime heureDebut;
	 private LocalTime heureFini ;
	 
	 
	 
	public PlageHoraire() {
		super();
	}



	public PlageHoraire(long id, LocalDate date, LocalTime heureDebut, LocalTime heureFini) {
		super();
		this.id = id;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFini = heureFini;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getHeureDebut() {
		return heureDebut;
	}



	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}



	public LocalTime getHeureFini() {
		return heureFini;
	}



	public void setHeureFini(LocalTime heureFini) {
		this.heureFini = heureFini;
	}



	@Override
	public int hashCode() {
		return Objects.hash(date, heureDebut, heureFini, id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageHoraire other = (PlageHoraire) obj;
		return Objects.equals(date, other.date) && Objects.equals(heureDebut, other.heureDebut)
				&& Objects.equals(heureFini, other.heureFini) && id == other.id;
	}



	@Override
	public String toString() {
		return "PlageHoraire [id=" + id + ", date=" + date + ", heureDebut=" + heureDebut + ", heureFini=" + heureFini
				+ "]";
	}
	 
	
	 
}
