package tn.banque.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.DemandeCreationCtit;


@Repository
public interface DemandeRepo extends CrudRepository<DemandeCreationCtit, Long> {

}
