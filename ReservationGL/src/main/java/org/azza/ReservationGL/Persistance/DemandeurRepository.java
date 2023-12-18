package org.azza.ReservationGL.Persistance;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
	public ArrayList<Demandeur> findByNom(String nom);
}
