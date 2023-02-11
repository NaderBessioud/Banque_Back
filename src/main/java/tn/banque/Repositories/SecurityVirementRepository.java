package tn.banque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.SecurityVirement;

@Repository
public interface SecurityVirementRepository extends JpaRepository<SecurityVirement, Long>{

	
	@Query(value="SELECT * FROM security_virement WHERE pass=:pass", nativeQuery = true)
	SecurityVirement findPass(@Param("pass") String pass);
	
	@Query(value="SELECT pass FROM security_virement WHERE  compte_idcc=:compte_idcc ", nativeQuery = true)
	String findPassCompte(@Param("compte_idcc") Long compte_idcc);

}
