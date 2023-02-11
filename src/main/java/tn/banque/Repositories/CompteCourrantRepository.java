package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.Virement;

@Repository
public interface CompteCourrantRepository extends JpaRepository<Comptecourrant, Long> {

	

	@Query(value="SELECT * FROM comptecourrant WHERE rib=:rib ", nativeQuery = true)
	Comptecourrant retrieveCompteByRib(@Param("rib") String rib);


	@Query(value="SELECT user.email\r\n"
			+ "FROM user \r\n"
			+ "JOIN comptebancaire ON user.id_employee = comptebancaire.usercomptebancaire_id_employee\r\n"
			+ "JOIN comptecourrant ON comptebancaire.comptecourrantbancaire_idcc = comptecourrant.idcc\r\n"
			+ "WHERE comptecourrant.idcc =:id_compte_courrant", nativeQuery = true)
	String EmailByComptecourrant(@Param("id_compte_courrant") Long id_compte_courrant);

}
