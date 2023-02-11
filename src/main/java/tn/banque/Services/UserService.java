package tn.banque.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
import tn.banque.Repositories.UserRepo;

@Service
public class UserService implements IuserService,UserDetailsService {
	@Autowired
	UserRepo userrp;
	
	public User finfByid(long id) {
		return userrp.findById(id).get();
	}

	@Override
	public User Ajouteruser(User u) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		u.setPassword(encoder.encode(u.getPassword()));
		u.setCreatedat(new Date());
		return userrp.save(u);
	}

	@Override
	public User Updateeruser(User u) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		u.setPassword(encoder.encode(u.getPassword()));
		u.setCreatedat(new Date());
		u.setApproved(true);
		return userrp.save(u);
	}

	@Override
	public void DeleteUser(Long id) {
		User u= userrp.findById(id).orElse(null);
            userrp.delete(u);		
	}

	@Override
	public List<User> Displayusers() {
		
		return (List<User>) userrp.findAll();
	}

	public User findByUserName(String username) {
			
		return userrp.findByEmail(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userrp.findByEmail(username);
		
		
		
		if((user==null)) {
			
			throw new  UsernameNotFoundException("User not found in database");
		}
		else {
			Collection<SimpleGrantedAuthority> authorites=new ArrayList<>();
			
			
			authorites.add(new SimpleGrantedAuthority(user.getRole().toString()));
			
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorites);
			
			
		
			
			
			
			
		}
	}
	
	
	
	public User approveUser(long id) {
		User user=userrp.findById(id).get();
		user.setApproved(true);
		
		return userrp.save(user);
	}
	
	public List<User> getEmployee(){
		List<User> result =new ArrayList<>();
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.CONSEILLER,false));
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.CONTROLLEUR_GESTION,false));
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.DIRECTION_FINANCIERE,false));
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.DIRECTION_RH,false));
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.GESTIONNAIRE_CLIENTELE,false));
		result.addAll(userrp.findByRoleAndApproved(TypeEmployee.GESTIONNAIRE_PATRIMOINE,false));
		
		System.out.print(result.size());
		return result;
	}
	
	public User getUserByemail(String email) {
		return userrp.findByEmail(email);
	}
	
	
	@Override
	public List<User> retrieveAllUser(){
		return userrp.retrieveAllUser();
	}
	
	
	@Override
	public Long FindComptecourrantByUserId(Long id) {
		return userrp.FindComptecourrantByUserId(id);
	}
	

}
