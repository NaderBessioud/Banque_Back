package tn.banque.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Compteepargne;

@Repository
public interface CompteEpargneRepository extends CrudRepository<Compteepargne, Long>{

}
