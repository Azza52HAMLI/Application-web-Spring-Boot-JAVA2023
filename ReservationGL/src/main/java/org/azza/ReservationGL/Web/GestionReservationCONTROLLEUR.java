package org.azza.ReservationGL.Web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.azza.ReservationGL.Persistance.Demandeur;
import org.azza.ReservationGL.Persistance.DemandeurRepository;
import org.azza.ReservationGL.Persistance.Facture;
import org.azza.ReservationGL.Persistance.FactureRepository;
import org.azza.ReservationGL.Persistance.PlageHoraire;
import org.azza.ReservationGL.Persistance.PlageHoraireRepository;
import org.azza.ReservationGL.Persistance.ReservatinoRepository;
import org.azza.ReservationGL.Persistance.Reservation;
import org.azza.ReservationGL.Persistance.Salle;
import org.azza.ReservationGL.Persistance.SalleRepository;
import org.azza.ReservationGL.logiqueMetier.FactureService;
import org.azza.ReservationGL.logiqueMetier.PlageHoraireService;
import org.azza.ReservationGL.logiqueMetier.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;






@Controller
public class GestionReservationCONTROLLEUR {
	@Autowired
	 private SalleRepository  srep;
	@Autowired
	 private FactureRepository frep;
	@Autowired
	 private ReservatinoRepository rrep;
	@Autowired
	 private PlageHoraireRepository prep;
	@Autowired
	 private DemandeurRepository  drep;
	@Autowired
	private PlageHoraireService ps;
	@Autowired
	private FactureService fser;
	@Autowired
	private ReservationService rser;

	 //A1
	//lorsque l'utilisateur sous trouve dan l'URL racine ,il se rederige vers la page ADDdemandeur
	@RequestMapping(value="/" )
	public String Login(Demandeur demandeur ) {
		return "redirect:/demandeur/Add";
		
	}
	//B1
	//affichage de page AddDemandeur
	@RequestMapping(value="/demandeur/Add")
	public String AddDemandeur(Demandeur demandeur)
	{
		return "AddDemandeur";
	}
	//C1
	//au cas ou le demandeur existe déjà  un messege d'erreur s'affiche dans la page echeclogin 
	// si non (cas d'inexistance de demandeur)  on effectue l'enregistrement de cet demandeur puis
	// la page reservation s'affiche
	@RequestMapping(value="/demandeur/Add/s'inscrire")
	public String inscrire(Model model ,Demandeur demandeur) {
		if (drep.findByNom(demandeur.getNom()).size()==0)
		{
	    model.addAttribute("Demandeur",demandeur);
	    drep.save(demandeur);
	    return "Reservation";
		}
		else {
			
			return "echecLogin";
		}
		
		
	}
	
   @RequestMapping(value = "/{id}/reservation/reserver")
	private String reserver(Model model,@PathVariable String id) {
		 List<Salle> salles = srep.findAll();
		 model.addAttribute("salles", salles);
		 model.addAttribute("id", id);
		 return "Reservation";
		 
		    }
   
   @RequestMapping(value = "/{id}/reservation/reserver/facture")
   public String AjouterFacture(Model model,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime heurDebut,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime heurFin, @PathVariable Long id,long numSalle) {
       PlageHoraire p = new PlageHoraire(id,date, heurDebut, heurFin);
	  PlageHoraire p1= ps.ReserverPlageHoraire(p);

	   
       Demandeur d1= drep.findById(id).get();
       Salle s1=srep.findById(numSalle).get();
       Facture f = new Facture(id,LocalDate.now(),false,Reservation.calculPrixLocation(s1.getSuperficie(), p.getHeureDebut(), p.getHeureFini()));
      
       fser.emmettreFacture(f);
       fser.imprimer(f);
       
       Reservation r1 = new Reservation(24587268l,s1,p,f,d1);
       
       model.addAttribute("salle", s1);
       model.addAttribute("demandeur", d1);
       model.addAttribute("facture", f);
       
       rser.confirmerReservation(r1);
       return "factureR";
   }
   
   
   
   
	}

	
	
	
	
	
	
	 
	 
	 
	 
 

