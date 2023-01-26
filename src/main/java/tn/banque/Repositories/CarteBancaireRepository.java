package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Cartebancaire;

@Repository
public interface CarteBancaireRepository extends JpaRepository<Cartebancaire, Long> {

	
	
	
	
	@Query(value="SELECT * FROM cartebancaire LEFT JOIN comptecourrant ON cartebancaire.idcb=comptecourrant.carteb_idcb WHERE comptecourrant.idcc=:comptecourrant_id  ", nativeQuery = true)
	Cartebancaire CarteByCompteId(@Param("comptecourrant_id") Long comptecourrant_id);

	
	@Query(value="SELECT COUNT(idcc) FROM comptecourrant t1 INNER JOIN cartebancaire t2  WHERE t1.carteb_idcb = t2.idcb GROUP BY t1.carteb_idcb", nativeQuery = true)
	int[] nbrCarte();
	
	@Query(value="SELECT nom FROM comptecourrant t1 INNER JOIN cartebancaire t2  WHERE t1.carteb_idcb = t2.idcb GROUP BY t1.carteb_idcb", nativeQuery = true)
	String[] nomCarte();
	
	@Query(value="SELECT nom, COUNT(idcc) FROM cartebancaire INNER JOIN comptecourrant WHERE cartebancaire.idcb = comptecourrant.carteb_idcb GROUP BY cartebancaire.nom", nativeQuery = true)
	String[][] nbrCarteUtil();
}
