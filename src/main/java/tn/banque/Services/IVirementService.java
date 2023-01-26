package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Virement;

public interface IVirementService {

	boolean addVirement(Virement virement, Long idCC);

	List<Object[]> retrieveAllVirement();

	List<Virement> retrieveVirementEmetteur(Long idCC);

	List<Virement> retrieveVirementRecepteur(Long idCC);

}
