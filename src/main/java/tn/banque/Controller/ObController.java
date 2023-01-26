package tn.banque.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;


import tn.banque.Entities.Obligation;
import tn.banque.Services.ISOb;
import tn.banque.Services.PDFGeneratorService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ob")
public class ObController {
	@Autowired
	ISOb service;
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	
	@PostMapping("/addob")
	@ResponseBody
	public Obligation addbenef(@RequestBody Obligation ob){
		return service.addOb(ob);
	}
	@DeleteMapping("/deleteob/{idO}")
	public void supprimerob(@PathVariable("idO") Long idO ){
		service.deleteOb(idO);
		}
	@GetMapping("/getob/{idO}")
	public Obligation getObligation(@PathVariable("idO")Long idO) {
		return service.retrieveOb(idO);
	}
	@GetMapping("/getallob")
	public List<Obligation> getAllObligation(){
		return service.retrieveAllOb();
	}
	@PutMapping("/modifob")
	public Obligation modifOblig(@RequestBody Obligation ob) {
		return service.updateOb(ob);
	}
	@PostMapping("/importob")
	public void importCsvToDBJob() {
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("startAt", System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
	        }
		catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
	            e.printStackTrace();
	        }
	    
	}
	@GetMapping(value = "/PDF")
	public ResponseEntity<InputStreamResource> employeeReport() throws IOException {
	List<Obligation> p = (List<Obligation>) service.retrieveAllOb();

	ByteArrayInputStream bis = PDFGeneratorService.employeePDFReport(p);
	HttpHeaders headers = new HttpHeaders();
	headers.add("Content-Disposition", "inline; filename=Obligations.pdf");

	return ResponseEntity.ok().headers(headers)
	  .body(new InputStreamResource(bis));
	}

	@GetMapping(value="/sim/{f}/{f1}/{f2}/{f3}/{f4}")
	public float yield(@PathVariable("f")float f,@PathVariable("f1")String f1,@PathVariable("f2")float f2
	,@PathVariable("f3")float f3,@PathVariable("f4")int f4) {
		return service.yieldtomaturity(f, f1, f2, f3, f4);
	}
	@GetMapping(value="/simob/{f}/{f1}")
	public int comparer(@PathVariable("f")Long f,@PathVariable("f1")Long f1) {
		return service.simuler2obs(f, f1);
	}
	@GetMapping(value="/simulateur/{f}/{f1}/{f2}/{f3}/{f4}")
	public List<Float> simulateur(@PathVariable("f")float f,@PathVariable("f1")String f1,@PathVariable("f2")float f2
	,@PathVariable("f3")float f3,@PathVariable("f4")int f4) {
		return service.simulateur(f, f1, f2, f3, f4);
	}
	
	

}
