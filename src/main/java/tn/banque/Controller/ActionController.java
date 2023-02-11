package tn.banque.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Action;
import tn.banque.Repositories.ActionRepository;
import tn.banque.Services.IActionService;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping("/Action")
public class ActionController {
	@Autowired
	IActionService actservice;
	@Autowired
	ActionRepository actrep;
	
	
	@PostMapping("/AddAction")
	@ResponseBody
	public Action addAction(@RequestBody Action p)
	{
	return actservice.addAction(p);
	}
	
	@GetMapping("/RetrieveAllAction")
	@ResponseBody
	public List<Action> getAction() {
	List<Action> listAction = actservice.retrieveAllAction();
	return listAction;
	}
	
	@GetMapping("/RetrieveAction")
	@ResponseBody
	public Action retrieveAction(@RequestParam("ActionId") Long ActionId) {
	return actservice.retrieveAction(ActionId);
	}
	
	@DeleteMapping("/RemoveAction")
	@ResponseBody
	public void removeAction(@RequestParam("ActionId") Long ActionId) {
	actservice.deleteAction(ActionId);
	}
	
	@GetMapping("/Actions")
	  public ResponseEntity<List<Action>> getAllActions(@RequestParam(required = false) String title) {

	    try {
	      List<Action> tutorials = new ArrayList<Action>();

	      if (title == null)
	        actrep.findAll().forEach(tutorials::add);
	      else
	        actrep.findByTitreContaining(title).forEach(tutorials::add);

	      if(tutorials.isEmpty())
	      {
	    	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	
}
