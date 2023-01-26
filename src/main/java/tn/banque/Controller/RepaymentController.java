package tn.banque.Controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Repayment;
import tn.banque.Services.ICreditsService;
import tn.banque.Services.IRepaymentService;
 
 
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/repayment")
public class RepaymentController {
	@Autowired
	ICreditsService creditsService;
 	@Autowired
	IRepaymentService repaymentService;
	
	@GetMapping("/select")
	@ResponseBody
	public List<Repayment>getRepayment(){
		List<Repayment>listRepayments = repaymentService.retrieveAllRepayments();
		return listRepayments;
	}
	@GetMapping("/selectcreditrepayments/{id}")
	@ResponseBody
	public List<Repayment>getRepaymentbyCredit(@PathVariable("id") Long Id){
		List<Repayment>listRepayments = repaymentService.getbycredits(Id);
		return listRepayments;
	}
	@GetMapping("/unpaid")
	@ResponseBody
	public List<Repayment>getRepaymentunpaid(){
		List<Repayment>listRepayments = repaymentService.retrieveUnpaidRepayments();
		return listRepayments;
	}
	 
	@GetMapping("/select/{id}")
	@ResponseBody
	public Repayment getRepayment(@PathVariable("id") Long Id){
		 Repayment f = repaymentService.retrieveRepayment(Id);
		return f;
	}
	@GetMapping("/shit/{id}")
	@ResponseBody
	public Repayment getRepaymentbygarantors(@PathVariable("id") Long Id){
		 Repayment f = repaymentService.retrieveRepayment(Id);
		return f;
	}
	@PostMapping("/add")
	@ResponseBody
	public Repayment addRepayment(@RequestBody Repayment x  )
	{
	Repayment f = repaymentService.addRepayment(x);
	return f;

	}
	 
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeRepayment(@PathVariable("id") Long Id) {
	repaymentService.deleteRepayment(Id);
	}

 	@PutMapping("/update")
	@ResponseBody
	public Repayment modifyRepayment(@RequestBody Repayment f  ) {
	return repaymentService.updateRepayment(f);
	}
 	
 /*	@GetMapping("/export/pdf/{id}")
	@ResponseBody
	    public void exportToPDF( HttpServletResponse response,@PathVariable("id") Long Id) throws DocumentException, IOException
 	{
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Guarantor_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        //List<Credits>  listcredits = creditsService.afficherselongarantor(Id);
	        List<Repayment> listrepayments = new ArrayList()<Repayment>();
	        for (Iterator<Credits> iterator = listcredits.iterator(); iterator.hasNext();) {
				Credits credits = (Credits) iterator.next();
				listrepayments.addAll(repaymentService.getbycredits(credits.getID()));
				
			}
	     
 
	        Guarantorpdfexporter exporter = new Guarantorpdfexporter(listrepayments);
	       exporter.export(response);  
	         
	    }*/
}