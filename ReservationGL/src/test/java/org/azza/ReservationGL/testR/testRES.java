package org.azza.ReservationGL.testR;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.azza.ReservationGL.Persistance.Reservation;
import org.junit.jupiter.api.Test;

class testRES {

	@Test
	void testprix() {
		assertEquals(420,Reservation.calculPrixLocation(600f, LocalTime.of(10, 00), LocalTime.of(20, 00)));


	}

}
