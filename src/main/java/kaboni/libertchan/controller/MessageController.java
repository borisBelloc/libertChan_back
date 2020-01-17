package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Message;
import kaboni.libertchan.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Message> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/number/{postNumber}")
	public Message findByEmail(@PathVariable Long postNumber) {
		return service.findByPostNumber(postNumber).orElse(null);
	}
	
	@GetMapping("/{id}")
	public Message findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
}
