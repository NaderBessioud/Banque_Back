package tn.banque.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	
	
	Optional<User> findByIdEmployee(Long id);
	
	List<User> findByRoleAndConge(TypeEmployee role,boolean conge);

	User findByEmail(String email);
	List<User> findByRoleAndApproved(TypeEmployee role,boolean app);
	
	@Query("Select u from User u join u.receivermessages m join m.sender s where s.idEmployee=?1 group by m.sender")
	List<User> gethistoriqueUserR(long id);
	
	@Query("Select u from User u join u.sendermessages m join m.receiver s where s.idEmployee=?1 group by m.receiver")
	List<User> gethistoriqueUserS(long id);
	
	@Query("Select distinct u from User u join u.employeerdv r join r.client us where us.idEmployee=?1 group by r.client")
	List<User> getEmployeeRDV(long id);
	
	@Query(value=" SELECT * FROM User u  WHERE u.role = ?1 ",nativeQuery= true)
	public List<User> getallUser( TypeEmployee role);
	
	
	@Query(value="SELECT *\n"
			+ "FROM user\n"
			+ "LEFT JOIN comptebancaire\n"
			+ "ON user.id_employee = comptebancaire.usercomptebancaire_id_employee\n"
			+ "WHERE (user.role = 8 OR user.role = 9 OR user.role = 10) AND comptebancaire.usercomptebancaire_id_employee IS NULL", nativeQuery=true)
	public List<User> retrieveAllUser();
	
	

	@Query(value="SELECT comptecourrantbancaire_idcc FROM comptebancaire INNER JOIN user WHERE user.id_employee=:userid", nativeQuery = true)
	Long FindComptecourrantByUserId(@Param("userid") Long userid);
	
}
