package org.azza.ReservationGL.Persistance;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Salle {
	@Id
	//@Column(name="nom_emp", nullable= false,length =99999 )
	@GeneratedValue(strategy = GenerationType.AUTO)
private int numS;
private int superficie;

public Salle() {
	super();
}

public Salle(int numS, int superficie) {
	super();
	this.numS = numS;
	this.superficie = superficie;
}

public long getNumS() {
	return numS;
}

public void setNumS(int numS) {
	this.numS = numS;
}

public int getSuperficie() {
	return superficie;
}

public void setSuperficie(int superficie) {
	this.superficie = superficie;
}

@Override
public String toString() {
	return "Salle [numS=" + numS + ", superficie=" + superficie + "]";
}

@Override
public int hashCode() {
	return Objects.hash(numS, superficie);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Salle other = (Salle) obj;
	return numS == other.numS && superficie == other.superficie;
}







}
