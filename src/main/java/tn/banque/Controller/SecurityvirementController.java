package tn.banque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Operationbancaire;
import tn.banque.Services.ISecurityvirementService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/securityvirement")
public class SecurityvirementController {

	@Autowired
	ISecurityvirementService isecurityvirementService;
	
	@PostMapping("/CheckPassCompte")
	@ResponseBody
	public boolean CheckPassCompte(@RequestParam("pass") String pass, @RequestParam("idCC") Long idCC ) {
		return isecurityvirementService.findComptePass(pass, idCC);
	}
	
}
