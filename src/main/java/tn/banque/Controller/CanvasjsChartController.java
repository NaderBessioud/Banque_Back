//CanvasjsChartController.java
package tn.banque.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
@RequestMapping("/StatAction")
public class CanvasjsChartController {
 
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/Statics")
	public String index() {
		return "actions/index";
	}
 
}       