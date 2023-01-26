package tn.banque.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import org.springframework.web.multipart.MultipartFile;

import tn.banque.Entities.Produitassurance;
import tn.banque.Entities.TypeAssurance;
import tn.banque.Entities.User;
import tn.banque.Services.EmailSenderService;
import tn.banque.Services.EmailService;
import tn.banque.Services.IprodAssuranceService;
import tn.banque.Services.IuserService;

@RestController
@RequestMapping("/Assurance")
@CrossOrigin("*")
public class ProdAssuranceController {
	@Autowired
	IprodAssuranceService prodservice;
	@Autowired
	EmailService email;
	@Autowired
	IuserService userserv;
	@GetMapping("/diplaye-prod")
   @ResponseBody
   public List<Produitassurance> getAllusers()
   {
		return prodservice.DisplayAssurance();
   }
	@PostMapping("/addprod")
	   @ResponseBody
	   public Produitassurance Adduser(@RequestBody Produitassurance u)
	   {
			return prodservice.Ajouteruser(u);
	   }
	@PutMapping("/modifiyprod")
	   @ResponseBody
	   public Produitassurance modifiy(@RequestBody Produitassurance u)
	   {
			return prodservice.Updateeruser(u);
	   }
	@DeleteMapping("/deleterod/{prrod-id}")
	   @ResponseBody
	   public void delete(@PathVariable("prrod-id") Long u)
	   {
		prodservice.DeleteUser(u);
	   }
	@PostMapping("/calculerassurance")
	   @ResponseBody
	   public Double calculassurance(@RequestParam("id") Long id)
	   {
			return prodservice.getMontantCreditAssuranceapayer(id);
	   }
	@PostMapping("excel")
	@Scheduled(cron = "0 */5 * ? * *")
	public String excelReader() {
		
		try {
			File file = new File("C:\\Users\\ASUS\\Desktop\\yassine.xlsx");   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);   
			for(int i=1; i<sheet.getPhysicalNumberOfRows();i++) {
				Produitassurance p =new Produitassurance();
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
					if(j==0)
						p.setIdPa((long) row.getCell(j).getNumericCellValue());
					if(j==1)
						p.setNomassurance(row.getCell(j).getStringCellValue());
					if(j==2)
						p.setPrime((float) row.getCell(j).getNumericCellValue());
					if(j==3)
						p.setRetrocomission((float) row.getCell(j).getNumericCellValue());
					if(j==4) {
						if (row.getCell(j).getStringCellValue().equals("Health_Insurance"))
							p.setTypeassurance(TypeAssurance.Health_Insurance);
						if (row.getCell(j).getStringCellValue().equals("Motor_Insurance"))
							p.setTypeassurance(TypeAssurance.Motor_Insurance);
						if (row.getCell(j).getStringCellValue().equals("Hom_Insurance"))
							p.setTypeassurance(TypeAssurance.Hom_Insurance);
						if (row.getCell(j).getStringCellValue().equals("Fir_Insurance"))
							p.setTypeassurance(TypeAssurance.Fir_Insurance);
						if (row.getCell(j).getStringCellValue().equals("Travel_Insurance"))
							p.setTypeassurance(TypeAssurance.Travel_Insurance);

					}
				}
				prodservice.Ajouteruser(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}
	@PostMapping("urgent")
	@Scheduled(cron = "0 */5 * ? * *")
	public String envoyer() {
		
		try {
			File file = new File("C:\\Users\\ASUS\\Desktop\\personnes.xlsx");   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0); 
			
			for(int i=1; i<sheet.getPhysicalNumberOfRows();i++) {

				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
					if(j==0)
for (User u : userserv.Displayusers()) {
	if(Long.parseLong(u.getCIN())==row.getCell(j).getNumericCellValue())
	{
		email.sendSimpleMessage("ministere.abc@gmail.com"
				+ "", "urgent", "La persone ayant le cin numero "+ row.getCell(j).getNumericCellValue()+" ayant des suspects de terrorisme veut avoir un credi de la part de notre banque");
	}
	
}				
				}
				System.out.println("");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}
	
}
