package tn.banque.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.Entities.Message;
import tn.banque.Services.MessageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/Messages")
	@ResponseBody
	public List<Message> getMessages(@RequestParam("ids") long ids,@RequestParam("idr") long idr){
		return messageService.getMessage(ids, idr);
	}
	
	@GetMapping("/addMessage")
	@ResponseBody
	public Message addMessage(@RequestParam("content") String message,@RequestParam("ids") long ids,@RequestParam("idr") long idr) throws ParseException {
		return messageService.addMessage(message, ids, idr);
	}
	
}
