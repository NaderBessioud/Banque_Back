package tn.banque.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tn.banque.Entities.RDVdate;
import tn.banque.Entities.User;
import tn.banque.Services.ConseillerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/conseiller")

public class ConseillerController {
	@Autowired
	private ConseillerService  conseillerService;
	
	/*@GetMapping("/rdv")
	@ResponseBody
	public List<RDVdate> getConseillerRDV(){
		return conseillerService.getConseillerRDV();
	}*/
	
	@GetMapping("/freeTime")
	@ResponseBody
	public List<RDVdate> getConseillerFreeTime(@RequestParam("lat") double lat,@RequestParam("lng") double lng){
		return conseillerService.getConseillerFreeTime(lat,lng);
	}
	
	@GetMapping("/freeTimeWAddr")
	@ResponseBody
	public List<RDVdate> getConseillerFreeTimeWAddr(@RequestParam("addr") String addr) throws ClientProtocolException, IOException{
		return conseillerService.getConseillerFreeTimeWAddr(addr);
	}
	
	@GetMapping("/address")
	@ResponseBody
	public void getAddress(@RequestParam("addr") String addr) throws ClientProtocolException, IOException {
		conseillerService.geocode(addr);
	}
	
	@GetMapping("/ConseillerProche")
	@ResponseBody
	public User getConseillerProche(@RequestParam("lat") double lat,@RequestParam("lng") double lng) throws ClientProtocolException, IOException {
		return conseillerService.getConseillerProche(lat, lng);
	}
	
	@GetMapping("/ConseillerProcheWAddr")
	@ResponseBody
	public User getConseillerProche(@RequestParam("addr") String addr ) throws ClientProtocolException, IOException {
		return conseillerService.getConseillerProcheWAddr(addr);
	}

}
