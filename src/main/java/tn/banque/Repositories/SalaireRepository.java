package tn.banque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Salaire;

@Repository
public interface SalaireRepository extends JpaRepository<Salaire, Long> {

}
