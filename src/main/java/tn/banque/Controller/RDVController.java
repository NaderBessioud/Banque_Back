package tn.banque.Controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
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
import tn.banque.Entities.RDVdate;
import tn.banque.Entities.User;
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
	
	@GetMapping("/frais")
	@ResponseBody
	public float getRDVFrais(@RequestParam("id") long id) {
		return rdvService.getRDVFrais(id);
	}
	

	@GetMapping("/freeTime")
	@ResponseBody
	public List<RDVdate> getConseillerFreeTime(@RequestParam("lat") double lat,@RequestParam("lng") double lng){
		return rdvService.getConseillerFreeTime(lat,lng);
	}
	
	@GetMapping("/freeTimeWAddr")
	@ResponseBody
	public List<RDVdate> getConseillerFreeTimeWAddr(@RequestParam("addr") String addr) throws ClientProtocolException, IOException{
		return rdvService.getConseillerFreeTimeWAddr(addr);
	}
	
	@GetMapping("/address")
	@ResponseBody
	public void getAddress(@RequestParam("addr") String addr) throws ClientProtocolException, IOException {
		rdvService.geocode(addr);
	}
	
	@GetMapping("/ConseillerProche")
	@ResponseBody
	public User getConseillerProche(@RequestParam("lat") double lat,@RequestParam("lng") double lng) throws ClientProtocolException, IOException {
		return rdvService.getConseillerProche(lat, lng);
	}
	
	@GetMapping("/ConseillerProcheWAddr")
	@ResponseBody
	public User getConseillerProche(@RequestParam("addr") String addr ) throws ClientProtocolException, IOException {
		return rdvService.getConseillerProcheWAddr(addr);
	}
}
