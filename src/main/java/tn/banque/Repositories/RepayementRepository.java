package tn.banque.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.Repayment;
@Repository
public interface RepayementRepository extends CrudRepository<Repayment, Long> {
	
	@Query("SELECT r FROM Repayment r WHERE term > :d")
	List<Repayment>  unpaidRepayments(@Param("d") Date d);
	List<Repayment> findByCredit_ID(long id);
}
