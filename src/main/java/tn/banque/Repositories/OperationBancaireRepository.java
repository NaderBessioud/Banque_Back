package tn.banque.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Operationbancaire;

@Repository
public interface OperationBancaireRepository extends JpaRepository<Operationbancaire, Long> {

	
	@Query(value="SELECT COALESCE(SUM(somme),0) FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=2   AND comptecourranto_idcc=:comptecourranto_idcc", nativeQuery = true)
	float SommeDiffereMois(@Param("comptecourranto_idcc") Long comptecourranto_idcc);
	
	@Query(value="SELECT * FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=2   AND comptecourranto_idcc=:comptecourranto_idcc", nativeQuery = true)
	List<Operationbancaire> OperationAVenir(@Param("comptecourranto_idcc") Long comptecourranto_idcc);
	
	@Query(value="SELECT COALESCE(SUM(somme),0) FROM operationbancaire WHERE typeoperation=0 AND comptecourranto_idcc=:comptecourranto_idcc AND created_at BETWEEN :dateDebut AND :dateFin ", nativeQuery = true)
	float SommeRetrait(@Param("comptecourranto_idcc") Long comptecourranto_idcc,@Param("dateDebut") LocalDate dateDebut,@Param("dateFin") LocalDate dateFin);
	
	
	
	
	

	@Query(value="SELECT COALESCE(SUM(somme),0) FROM operation_bancaire WHERE MONTH(create_at)=MONTH(NOW()) AND immediat=1 AND DAY(create_at)=DAY(NOW())-1 AND comptecourrant_idcc=:comptecourrant_idcc", nativeQuery = true)
	float SommeImmediat(@Param("comptecourrant_idcc") Long comptecourrant_idcc);
			
	@Query(value = "SELECT COALESCE(SUM(somme),0) FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=2 AND comptecourranto_idcc=:comptecourranto_idcc " , nativeQuery = true)
	float SommeAchatMois(@Param("comptecourranto_idcc") Long comptecourranto_idcc);		
	
	@Query(value = "SELECT COALESCE(SUM(somme),0) FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=2 AND comptecourranto_idcc=:comptecourranto_idcc " , nativeQuery = true)
	float statAchat(@Param("comptecourranto_idcc") Long comptecourranto_idcc);		
	
	@Query(value = "SELECT COALESCE(SUM(somme),0) FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=0 AND comptecourranto_idcc=:comptecourranto_idcc " , nativeQuery = true)
	float statRetrait(@Param("comptecourranto_idcc") Long comptecourranto_idcc);		
	
	@Query(value = "SELECT  COALESCE(SUM(somme),0) FROM operationbancaire WHERE MONTH(created_at)=MONTH(NOW()) AND typeoperation=1 AND comptecourranto_idcc=:comptecourranto_idcc " , nativeQuery = true)
	float statDepot(@Param("comptecourranto_idcc") Long comptecourranto_idcc);		
	
	
	@Query(value = "SELECT DATE_FORMAT(created_at, '%M') as month, YEAR(created_at) as year, " +
            "SUM(CASE WHEN typeoperation = 2 THEN somme ELSE 0 END) AS somme_achat, " +
            "SUM(CASE WHEN typeoperation = 0 THEN somme ELSE 0 END) AS somme_retrait, " +
            "SUM(CASE WHEN typeoperation = 1 THEN somme ELSE 0 END) AS somme_depot ," +
            "SUM(CASE WHEN typeoperation = 1 THEN somme ELSE 0 END)- SUM(CASE WHEN typeoperation = 2 THEN somme ELSE 0 END) - SUM(CASE WHEN typeoperation = 0 THEN somme ELSE 0 END) as somme_depot_moins_retrait "+
            "FROM operationbancaire " +
            "GROUP BY MONTH(created_at), YEAR(created_at)", nativeQuery = true)
List<Object[]> findSommeByTypeOperationGroupByMonthAndYear();


@Query(value = "SELECT operationbancaire.*, comptecourrant.ref as reference_compte_courant, comptebancaire.ref as reference_compte_bancaire FROM operationbancaire JOIN comptecourrant ON operationbancaire.comptecourranto_idcc = comptecourrant.idcc JOIN comptebancaire ON comptecourrant.idcc = comptebancaire.comptecourrantbancaire_idcc", nativeQuery = true)
List<Object[]> findOperationBancaireWithCompteCourantAndCompteBancaire();

	

	
	
	
	
	@Query(value="SELECT * FROM operationbancaire WHERE comptecourranto_idcc=:comptecourranto_idcc ", nativeQuery = true)
	List<Operationbancaire> OperationByCompte(@Param("comptecourranto_idcc") Long comptecourranto_idcc);

	
	
}
