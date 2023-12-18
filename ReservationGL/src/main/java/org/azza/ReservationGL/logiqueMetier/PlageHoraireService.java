package org.azza.ReservationGL.logiqueMetier;

import java.util.List;

import org.azza.ReservationGL.Persistance.PlageHoraire;
import org.azza.ReservationGL.Persistance.PlageHoraireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class PlageHoraireService {
	@Autowired
	private PlageHoraireRepository repPlage;

	
	
	public PlageHoraireService(PlageHoraireRepository repPlage) {
		super();
		this.repPlage = repPlage;
	}



	public PlageHoraire ReserverPlageHoraire( PlageHoraire plageH) {
		return repPlage.save(plageH);
	}
	

	public void libererPlageHoraire( PlageHoraire plageH) {
		 repPlage.delete(plageH);
	}

public boolean IsLibre(PlageHoraire plageH) {
	
	List<PlageHoraire> plageOccupé =repPlage.findAll();
	
	
	return !plageOccupé.contains(plageH);
}


}



	
