package tn.banque.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.banque.Entities.User;

@Service
public interface IuserService {
	public  User Ajouteruser(User u);
	public  User Updateeruser(User u);
	public void DeleteUser(Long id);
	public List<User>  Displayusers();

	

}
