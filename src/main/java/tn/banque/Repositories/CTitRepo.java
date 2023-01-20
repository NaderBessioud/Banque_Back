package tn.banque.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Comptetitre;

@Repository
public interface CTitRepo extends CrudRepository<Comptetitre, String> {
	@Query("SELECT c from Comptetitre c WHERE c.comptebancairet.clcomptes.idEmployee= :id")
	List<Comptetitre> getcomptetitre(@Param("id") Long id);
	@Query("SELECT c from Comptetitre c WHERE c.comptebancairet.idCBA= :id")
	Comptetitre getcompte(@Param("id") Long id);
}
