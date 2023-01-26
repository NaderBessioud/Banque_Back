package tn.banque.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Produitassurance;
@Repository
public interface ProdAssuraceRepo extends CrudRepository<Produitassurance, Long> {

}
