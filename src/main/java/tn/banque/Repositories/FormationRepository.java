package tn.banque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long>{

}
