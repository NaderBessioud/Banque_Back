package tn.banque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Conge;

@Repository
public interface CongeRespository extends JpaRepository<Conge, Long> {

}
