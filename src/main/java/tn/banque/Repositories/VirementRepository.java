package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Operationbancaire;
import tn.banque.Entities.Virement;

@Repository
public interface VirementRepository extends JpaRepository<Virement, Long>{

	
	@Query(value="SELECT * FROM virement WHERE ribe=:ribe ", nativeQuery = true)
	List<Virement> retrieveVirementRibEmetteur(@Param("ribe") String ribe);
	
	

	@Query(value="SELECT * FROM virement WHERE ribr=:ribr ", nativeQuery = true)
	List<Virement> retrieveVirementRibRecepteur(@Param("ribr") String ribr);
	



	@Query(value="SELECT virement.*, comptecourrant.ref \r\n"
			+ "FROM virement \r\n"
			+ "JOIN comptecourrant ON virement.virementcompte_idcc = comptecourrant.idcc", nativeQuery = true)
	List<Object[]> virementRef();

}
