package org.azza.ReservationGL;

import java.time.LocalDate;
import java.time.LocalTime;

import org.azza.ReservationGL.Persistance.Demandeur;
import org.azza.ReservationGL.Persistance.DemandeurRepository;
import org.azza.ReservationGL.Persistance.Facture;
import org.azza.ReservationGL.Persistance.FactureRepository;
import org.azza.ReservationGL.Persistance.PlageHoraire;
import org.azza.ReservationGL.Persistance.PlageHoraireRepository;
import org.azza.ReservationGL.Persistance.SalleRepository;
import org.azza.ReservationGL.Persistance.ReservatinoRepository;
import org.azza.ReservationGL.Persistance.Reservation;
import org.azza.ReservationGL.Persistance.Salle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



import org.azza.ReservationGL.logiqueMetier.FactureService;
import org.azza.ReservationGL.logiqueMetier.PlageHoraireService;
import org.azza.ReservationGL.logiqueMetier.ReservationService;

@SpringBootApplication
public class ReservationGlApplication {

	public static void main(String[] args) {
		 ApplicationContext cxt= SpringApplication.run(ReservationGlApplication.class, args);
		 
			DemandeurRepository repDemandeur=cxt.getBean(DemandeurRepository.class);
			FactureRepository repFacture=cxt.getBean(FactureRepository.class);
			ReservatinoRepository repReservation=cxt.getBean(ReservatinoRepository.class);
			PlageHoraireRepository repPlageHoraire=cxt.getBean(PlageHoraireRepository.class);
			SalleRepository repSalle=cxt.getBean(SalleRepository.class);
			
		
			FactureService serFacture=cxt.getBean(FactureService.class);
			ReservationService serReservation=cxt.getBean(ReservationService.class);
			PlageHoraireService serPlage=cxt.getBean(PlageHoraireService.class);
			
			Demandeur d1=new Demandeur(00012l,"sami","Route de l'aéroport klm 7");
			Demandeur d3=new Demandeur(00012l,"hazem","Nassria");
			Demandeur d2=new Demandeur(00012l,"amal","Route de Taniour klm 1.5");
			Salle s1=new Salle(0025, 670);
			Salle s2=new Salle(0045, 570);
			Salle s3=new Salle(002255, 800);
			PlageHoraire p= new PlageHoraire(42,LocalDate.now(),LocalTime.NOON,LocalTime.MIDNIGHT);
			PlageHoraire p1= new PlageHoraire(42,LocalDate.now(),LocalTime.NOON,LocalTime.MIDNIGHT);
			PlageHoraire p2= new PlageHoraire(42,LocalDate.now(),LocalTime.NOON,LocalTime.MIDNIGHT);
			
		    Facture f1 = new Facture(0025254L,LocalDate.now(),false,Reservation.calculPrixLocation(s1.getSuperficie(), p.getHeureDebut(), p.getHeureFini()));
		
		   repDemandeur.save(d1);
			repDemandeur.save(d2);
			repDemandeur.save(d3);
			repFacture.save(f1);
			//repFacture.save(f3);
			repPlageHoraire.save(p);
			repPlageHoraire.save(p1);
			repPlageHoraire.save(p2);
			repSalle.save(s1);
			repSalle.save(s2);
			repSalle.save(s3);
			Reservation r1 =new Reservation (112l,s1,p,f1,d1);
			Reservation r2 =new Reservation (11121,s2,p1,f2,d2);
		//	Reservation r2 =new Reservation (142l,s2,p1,f2,d2);
		//	Reservation r3 =new Reservation (12l,s3,p2,f3,d3);
			
			repReservation.save(r1);
			//repReservation.save(r2);
		//	repReservation.save(r3);
	}

}
