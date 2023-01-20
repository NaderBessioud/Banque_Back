package tn.banque.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Obligation;


@Repository
public interface ObRepo extends CrudRepository<Obligation, Long> {

}
