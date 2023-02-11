package tn.banque.Services;

import java.util.List;

import tn.banque.Entities.Operationbancaire;

public interface IOperationbancaireService {

	List<Operationbancaire> retrieveAllOperation();

	boolean addDepot(Operationbancaire operation, Long idCC);

	List<Operationbancaire> retrieveByCompte(Long idCC);

	boolean addAchat(Operationbancaire operation, Long idCC);

	boolean addRetrait(Operationbancaire operation, Long idCC);

	float currentRetrait(Long idCC);

	float currentPaiement(Long idCC);

	float[] statOperation(Long idCC);

	List<Operationbancaire> OperationAVenir(Long idCC);

	List<Object[]> StatOperationMois();

	List<Object[]> AllOperationCompte();

}
