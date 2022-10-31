package tn.banque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.RDV;
import tn.banque.Services.RDVService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rdv")

public class RDVController {

	@Autowired
	private RDVService rdvService;
	
	@PostMapping("/addRDV")
	@ResponseBody
	public RDV addRDV(@RequestBody RDV rdv,@RequestParam("id") long id,@RequestParam("idc") long idc) {
		return rdvService.addRDV(rdv,id,idc);
	}
	
	@GetMapping("/ClientRdv")
	@ResponseBody
	public List<RDV> getClientRDV(@RequestParam("idc") long idc){
		return rdvService.getClientRDV(idc);
	}
}
