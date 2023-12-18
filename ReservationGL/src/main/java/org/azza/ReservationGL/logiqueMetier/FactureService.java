package org.azza.ReservationGL.logiqueMetier;

import java.time.LocalDate;

import org.azza.ReservationGL.Persistance.Facture;
import org.azza.ReservationGL.Persistance.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class FactureService {

	    @Autowired
	    private FactureRepository factureRepository;
	    

	    public FactureService(FactureRepository factureRepository) {
			super();
			this.factureRepository = factureRepository;
		}


		public Facture emmettreFacture(Facture fact) {
	    	boolean envoyé = true;
	        fact.setDate(LocalDate.now());
	        fact.setEtat(envoyé);
	        return factureRepository.save(fact);
	    }
		//IMPRESSION
		
		//
		public void imprimer(Facture facture) {
			System.out.println("Facture pour"+facture.getNumero());
			System.out.println("le montant"+facture.getMontant());
			System.out.println(" Date "+facture.getDate());
		}
		//PRIN
		public Facture ImprimerF(Facture facture) {
			Facture fact =factureRepository.findById(facture.getNumero()).orElseThrow(() -> new IllegalArgumentException("Facture introuvable"));
			imprimer(fact);
			return facture;
		}
		
		
		
		
		}
		
