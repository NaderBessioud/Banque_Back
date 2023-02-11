package tn.banque.Controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Comptecourrant;
import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
import tn.banque.Security.JWTTokenProvider;
import tn.banque.Security.UserPrincipal;
import tn.banque.Services.IuserService;
import tn.banque.Services.MessageService;
import tn.banque.Services.RDVService;
import tn.banque.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	JWTTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MessageService messageService;
	@Autowired
    private SimpMessagingTemplate template;
	@Autowired
	private RDVService rdvService;
	
	private final List<User> UserOnLine=new ArrayList<>();
	
	
	@GetMapping("/diplaye-users")
   @ResponseBody
   public List<User> getAllusers()
   {
		return userservice.Displayusers();
   }
	@PostMapping("/adduser")
	   @ResponseBody
	   public User Adduser(@RequestBody User u)
	   {
		u.setSalaire(0);
			return userservice.Ajouteruser(u);
	   }
	
	@GetMapping("/User")
	@ResponseBody
	public User getUser(@RequestParam("id") long id) {
		return userservice.finfByid(id);
	}
	@PutMapping("/modifiyuser")
	   @ResponseBody
	   public User modifiy(@RequestBody User u)
	   {
			return userservice.Updateeruser(u);
	   }
	@DeleteMapping("/deleteuser/{user-id}")
	   @ResponseBody
	   public void delete(@PathVariable("user-id") Long u)
	   {
			 userservice.DeleteUser(u);
	   }
	
	
	
	
	@GetMapping("/login")
	@ResponseBody
	public User Login( @RequestParam("username") String username,@RequestParam("pass") String pass,HttpServletRequest request) throws Exception {
		
	
		int result=0;
		
		
		result =authenticate(username,pass);
		
		if(result == 0) {
		
		User ag=userservice.findByUserName(username);

		String token="";
		
		
		
		UserPrincipal principal;
		
		if(ag != null) {
			//authenticationSuccessHandler.loginAgentNotification(ag, request);
			 principal=new UserPrincipal(ag);
			  token=jwtTokenProvider.generateToken(principal);
			  ag.setToken(token);
			  UserOnLine.add(ag);
			  ag.setOnline(true);
			  template.convertAndSend("/topic/online", ag);
			  
			  
		}
	
		
		
		return ag;
		}
		else 
			return null;
		
	}
	
	
	
	
	private int authenticate(String username, String pass) throws Exception{
		try {
		SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pass)));
			return 0;
			


			
		}
		catch (DisabledException ex) {
			return 1;
		}
		catch (BadCredentialsException ex) {
			
			return 2;
		}catch (Exception e) {
			System.out.print(e.getStackTrace());
			return 3;
		}
		
	}
	
	@PutMapping("/approveUser")
	@ResponseBody
	public User approveUser(@RequestBody User user) {
		return userservice.approveUser(user.getIdEmployee());
	}
	
	@GetMapping("/Employees") 
	@ResponseBody
	public List<User> getEmployees(){
		return userservice.getEmployee();
	}
	
	@GetMapping("/userOnLine")
	@ResponseBody
	public List<User> getUserOnLine(@RequestParam("id") long id){
		List<User> userConnected=new ArrayList<>();
		List<User> result =new ArrayList<User>();
		
		for (User user : userConnected) {
			user.setOnline(true);
		}
		String email=userservice.finfByid(id).getEmail();
		User userc=userservice.finfByid(id);
		if(userc.getRole()==TypeEmployee.PARTICULIER) {
			
			result.addAll(rdvService.getEmployeeRDV(id));
			for (User user : result) {
				boolean exist=false;
				for (User user2 : userConnected) {
					if(user.getEmail().equals(user2.getEmail())) {
						user.setOnline(true);
					}
				}
				
			}
			return result;
			}
			
		for (User user : UserOnLine) {
			if(! user.getEmail().equals(email)) {
				userConnected.add(user);
			}
		}
	
		
		result.addAll(userConnected);
		
		for (User user : messageService.getHistoriqueuser(id)) {
			boolean exist=false;
			for (User user2 : result) {
				if(user.getEmail().equals(user2.getEmail())) {
					exist=true;
				}
			}
			if(exist==false) {
				result.add(user);
			}
		}
		
		
		
		return result;
	}
	
	@GetMapping("/logout")
	public void logout(@RequestParam("email") String email) {
		User u=userservice.getUserByemail(email);
		System.out.println(UserOnLine);
		/*for (User user : UserOnLine) {
			if(user.getEmail().equals(email)) { 
				UserOnLine.remove(user); 
			} 
			
		
		}*/
		
		for(int i=0;i<UserOnLine.size();i++) {
			if(UserOnLine.get(i).getEmail()==email) {
				UserOnLine.remove(i);
			}
		}
		template.convertAndSend("/topic/offline", u);
	}
	
	
	@GetMapping("/retrieveAllUser")
	public List<User> retieveAllComptecourrant(){
		List<User> list = userservice.retrieveAllUser();
	return list;
	}
	
	
	
	@GetMapping("/FindComptecourrantByUserId")
	public Long FindComptecourrantByUserId(@RequestParam("id")Long id) {
		Long result = userservice.FindComptecourrantByUserId(id);
		return  result;
	}
	
}

