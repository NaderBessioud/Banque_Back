package tn.banque.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.User;
@Repository

public interface UserRepo extends CrudRepository<User, Long> {

}
