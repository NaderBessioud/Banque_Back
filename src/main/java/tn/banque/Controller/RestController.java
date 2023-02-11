package tn.banque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.banque.Entities.Action;
import tn.banque.Services.CanvasjsChartService;
import tn.banque.Services.IActionService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "api/product")
public class RestController{
		
	@Autowired
	private IActionService actionService;
	
	
	@GetMapping("/findall")
    @ResponseBody
    public Iterable < Action > users1() {
        Iterable < Action > actions = Arrays.asList();
        actions = actionService.findAll();
        return actions;
    }
	
} 
