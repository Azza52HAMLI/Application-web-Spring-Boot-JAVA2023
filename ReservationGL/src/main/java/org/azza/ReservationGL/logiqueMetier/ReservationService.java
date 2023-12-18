package org.azza.ReservationGL.logiqueMetier;

import org.azza.ReservationGL.Persistance.ReservatinoRepository;
import org.azza.ReservationGL.Persistance.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	@Autowired
	private ReservatinoRepository repSER;

	public ReservationService(ReservatinoRepository repSER) {
		super();
		this.repSER = repSER;
	}
	
	public void annulerReservation(Reservation r) {
		repSER.delete(r);
	}
	
	public void confirmerReservation(Reservation r) {
		repSER.save(r);
	}

}
