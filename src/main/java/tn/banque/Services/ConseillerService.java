package tn.banque.Services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Return;
import tn.banque.Entities.RDV;
import tn.banque.Entities.RDVdate;
import tn.banque.Entities.TypeEmployee;
import tn.banque.Entities.User;
import tn.banque.Repositories.ConseillerRepository;
import tn.banque.Repositories.RDVRepository;

@Service
public class ConseillerService {
	private final RestTemplate restTemplate= new RestTemplate();
	private static final String GEOCODING_RESOURCE = "https://geocode.search.hereapi.com/v1/geocode";
	private static final String API_KEY = "M9Dk4Ifo08ZLj0-qzJ16O_6inGFVUieLaHXU6OhhTmM";
	
	private static final String API_KEY1 = "RNKvIhAt1ICULZvUgG9a7nih-XkF4tsC7Zs0VunM9KmNXkx8LS1mE-7M2sUOzVj66Nav1hw03CpEbDQ5WD-lfw";

	@Autowired
	private ConseillerRepository conseillerRepository;
	
	@Autowired
	private RDVRepository rdvRepository;
	
	public  double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
	
	
	public List<RDVdate> getConseillerRDV(double lat,double lng){
		ZoneId defaultZoneId = ZoneId.systemDefault();
		List<RDVdate> dateTimes=new ArrayList<>();
		User user=new User();
		try {
			user = this.getConseillerProche(lat, lng);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		cal.add(Calendar.DAY_OF_MONTH, 4); 
		String dateAfters = sdf.format(cal.getTime());
		
		cal.setTime(new Date());
		
		cal.add(Calendar.DAY_OF_MONTH, 3); 
		String dateAfter = sdf.format(cal.getTime());
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1); 
		String dateAfter1 = sdf.format(cal.getTime());
		
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 2); 
		String dateAfter2 = sdf.format(cal.getTime());
		System.out.print("=============================>"+cal.getTime());
		
		   try{  
		
		List<RDV> rdvs=rdvRepository.findByEmployeeAndDaterdvBetween(user, new Date(), sdf.parse(dateAfters));
		System.out.print("how size"+rdvs.size());
		Calendar c = Calendar.getInstance();
		RDVdate rdvdate=new RDVdate(sdf.format(new Date()),new ArrayList<>()) ;
		
		RDVdate rdvdate1=new RDVdate(dateAfter1,new ArrayList<>()) ;
		
		RDVdate rdvdate2=new RDVdate(dateAfter2,new ArrayList<>()) ;
		
		RDVdate rdvdate3=new RDVdate(dateAfter,new ArrayList<>()) ;
		
		
		for (RDV rdv : rdvs) {
			

			
			 if(sdf.format(rdv.getDaterdv()).equals(rdvdate.getDate())) 
				 
			 
				 rdvdate.getHeure().add(rdv.getHeure()+":00");
			 
			 else if (sdf.format(rdv.getDaterdv()).equals(rdvdate1.getDate()))
				 rdvdate1.getHeure().add(rdv.getHeure()+":00");
			 else if (sdf.format(rdv.getDaterdv()).equals(rdvdate2.getDate()))
				 rdvdate2.getHeure().add(rdv.getHeure()+":00");
			 else if (sdf.format(rdv.getDaterdv()).equals(rdvdate3.getDate()))
				 rdvdate3.getHeure().add(rdv.getHeure()+":00");
			
			
		}
		dateTimes.add(rdvdate);
		dateTimes.add(rdvdate1);
		dateTimes.add(rdvdate2);
		dateTimes.add(rdvdate3);
		
		System.out.print("how Date->>>"+rdvdate1.getDate()+"->>>how format->>>>"+dateAfter1);
		   }catch(ParseException e){  
	            e.printStackTrace();  
	         }  
		
		return dateTimes; 
	}
	
	public List<RDVdate> getConseillerFreeTime(double lat,double lng){
		List<RDVdate> free=new ArrayList<>();
		List<RDVdate> rdv=this.getConseillerRDV(lat,lng);
		List<String> heures=new ArrayList<>();
		List<String> heures1=new ArrayList<>();
		List<String> heures2=new ArrayList<>();
		List<String> heures3=new ArrayList<>();
		heures.add("08");
		heures.add("10");
		heures.add("12");
		heures.add("14");
		heures.add("16");
		
		heures1.add("08");
		heures1.add("10");
		heures1.add("12");
		heures1.add("14");
		heures1.add("16");
		
		heures2.add("08");
		heures2.add("10");
		heures2.add("12");
		heures2.add("14");
		heures2.add("16");
		
		
		heures3.add("08");
		heures3.add("10");
		heures3.add("12");
		heures3.add("14");
		heures3.add("16");
		
		RDVdate freetime=new RDVdate(rdv.get(0).getDate(),new ArrayList<>());
		RDVdate freetime1=new RDVdate(rdv.get(1).getDate(),new ArrayList<>());
		RDVdate freetime2=new RDVdate(rdv.get(2).getDate(),new ArrayList<>());
		RDVdate freetime3=new RDVdate(rdv.get(3).getDate(),new ArrayList<>());
		for (String time : rdv.get(0).getHeure()) {
			System.out.print("how lwa9t=>>>>"+ LocalDateTime.now().getHour());
			if(time.subSequence(0, 2).equals("08") || LocalDateTime.now().getHour()>8)
				heures.remove("08");
			 if(time.subSequence(0, 2).equals("10") || LocalDateTime.now().getHour()>10)
				heures.remove("10");
			 if(time.subSequence(0, 2).equals("12") || LocalDateTime.now().getHour()>12)
				heures.remove("12");
			 if(time.subSequence(0, 2).equals("14") || LocalDateTime.now().getHour()>14)
				heures.remove("14");
			 if(time.subSequence(0, 2).equals("16") || LocalDateTime.now().getHour()>16)
				heures.remove("16");
			
		}
		
		
		freetime.getHeure().addAll(heures);
		
		
		for (String time : rdv.get(1).getHeure()) {
			if(time.subSequence(0, 1).equals("08"))
				heures1.remove("08");
			 if(time.subSequence(0, 2).equals("10"))
				heures1.remove("10");
			 if(time.subSequence(0, 2).equals("12"))
				heures1.remove("12");
			 if(time.subSequence(0, 2).equals("14"))
				heures1.remove("14");
			 if(time.subSequence(0, 2).equals("16"))
				heures1.remove("16");
			
		}
		freetime1.getHeure().addAll(heures1);
		
		for (String time : rdv.get(2).getHeure()) {
			if(time.subSequence(0, 2).equals("08"))
				heures2.remove("08");
			 if(time.subSequence(0, 2).equals("10"))
				heures2.remove("10");
			 if(time.subSequence(0, 2).equals("12"))
				heures2.remove("12");
			 if(time.subSequence(0, 2).equals("14"))
				heures2.remove("14");
			 if(time.subSequence(0, 2).equals("16"))
				heures2.remove("16");
			
		}
		freetime2.getHeure().addAll(heures2);
		
		for (String time : rdv.get(3).getHeure()) {
			if(time.subSequence(0, 1).equals("08"))
				heures3.remove("08");
			 if(time.subSequence(0, 2).equals("10"))
				heures3.remove("10");
			 if(time.subSequence(0, 2).equals("12"))
				heures3.remove("12");
			 if(time.subSequence(0, 2).equals("14"))
				heures3.remove("14");
			 if(time.subSequence(0, 2).equals("16"))
				heures3.remove("16");
			
		}
		freetime3.getHeure().addAll(heures3);
		
		
		free.add(freetime);
		free.add(freetime1);
		free.add(freetime2);
		free.add(freetime3);
		return free;
	}
	
	public JsonNode geocode(String adress) throws ClientProtocolException, IOException {
		try {
			HttpClient httpclient = HttpClients.createDefault();
			String encodedQuery = URLEncoder.encode(adress,"UTF-8");
			String requestUri = GEOCODING_RESOURCE + "?apiKey=" + API_KEY + "&q=" + encodedQuery;
			HttpGet httppost = new HttpGet(requestUri);
			//List<NameValuePair> params = new ArrayList<NameValuePair>(2);
			/*params.add(new BasicNameValuePair("param-1", "12345"));
			params.add(new BasicNameValuePair("param-2", "Hello!"));*/
			//httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse response = httpclient.execute(httppost);
			String responseString = new BasicResponseHandler().handleResponse(response);
			//JsonParser springParser = JsonParserFactory.getJsonParser();
		   // Map< String, Object > map = springParser.parseMap(this.restTemplate.getForObject(requestUri, String.class));
		    ObjectMapper mapper = new ObjectMapper();
		    JsonNode responseJsonNode = mapper.readTree(responseString);
		    JsonNode items = responseJsonNode.get("items");
		    
		    for (JsonNode item : items) {
	            JsonNode address = item.get("address");
	            String label = address.get("label").asText();
	            JsonNode position = item.get("position");

	            String lat = position.get("lat").asText();
	            String lng = position.get("lng").asText();
	            System.out.println(label + " is located at " + lat + "," + lng + ".");
	            return position;
	        }		    
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public User getConseillerProche(double lat,double lon) throws ClientProtocolException, IOException {
		
        
		List<User> conseillers=conseillerRepository.findByRoleAndConge(TypeEmployee.CONSEILLER, false);
		
		JsonNode position=this.geocode(conseillers.get(0).getAddresse());
		String lati = position.get("lat").asText();
        String lng = position.get("lng").asText();
		double distance=this.distance(lat, Double.parseDouble(lati), lon ,Double.parseDouble(lng), 0, 0);
		User user=conseillers.get(0);
		for(int i=1;i<conseillers.size();i++) {
			 position=this.geocode(conseillers.get(i).getAddresse());
				 lati = position.get("lat").asText();
		         lng = position.get("lng").asText();
			if(this.distance(lat, Double.parseDouble(lati), lon,Double.parseDouble(lng), 0, 0) < distance) {
				distance=this.distance(lat, Double.parseDouble(lati), lon, Double.parseDouble(lng), 0, 0);
				user=conseillers.get(i);
			}
		}
		
		return user;
	}
	
	
	public User getConseillerProcheWAddr(String addr) throws ClientProtocolException, IOException {
		
        
		List<User> conseillers=conseillerRepository.findByRoleAndConge(TypeEmployee.CONSEILLER, false);
		JsonNode position=this.geocode(conseillers.get(0).getAddresse());
		String lati = position.get("lat").asText();
        String lng = position.get("lng").asText();
        
        position=this.geocode(addr);
		String latic = position.get("lat").asText();
        String lngc = position.get("lng").asText();
		double distance=this.distance(Double.parseDouble(latic), Double.parseDouble(lati), Double.parseDouble(lngc) ,Double.parseDouble(lng), 0, 0);
		User user=conseillers.get(0);
		for(int i=1;i<conseillers.size();i++) {
			 position=this.geocode(conseillers.get(i).getAddresse());
				 lati = position.get("lat").asText();
		         lng = position.get("lng").asText();
			if(this.distance(Double.parseDouble(latic), Double.parseDouble(lati), Double.parseDouble(lngc),Double.parseDouble(lng), 0, 0) < distance) {
				distance=this.distance(Double.parseDouble(latic), Double.parseDouble(lati), Double.parseDouble(lngc), Double.parseDouble(lng), 0, 0);
				user=conseillers.get(i);
			}
		}
		
		return user;
	}
	
	public List<RDVdate> getConseillerFreeTimeWAddr(String addr) throws ClientProtocolException, IOException{
		JsonNode position =this.geocode(addr);
		String lati = position.get("lat").asText();
        String lng = position.get("lng").asText();
        return this.getConseillerFreeTime(Double.parseDouble(lati), Double.parseDouble(lng));
	}
	
	

}
