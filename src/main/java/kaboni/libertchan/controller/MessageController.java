package kaboni.libertchan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;
import kaboni.libertchan.service.DiscussionThreadService;
import kaboni.libertchan.service.MessageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@Autowired
	private DiscussionThreadService discussionThreadService;

	@GetMapping("/all")
	public List<Message> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Message> findAllByOrderByDateDesc() {
		return service.findAllByOrderByDateDesc();
	}
	
	@GetMapping("/topic/{topicId}")
	public List<Message> findByTopicId(@PathVariable Long topicId){
		DiscussionThread associateDiscussionThread = discussionThreadService.findByThreadId(topicId).orElse(null);
		return service.findByDiscussionThread(associateDiscussionThread);
	}
	
	@GetMapping("/number/{postNumber}")
	public Message findByPostNumber(@PathVariable Long postNumber) {
		return service.findByPostNumber(postNumber).orElse(null);
	}
	
	@GetMapping("/{id}")
	public Message findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Message save(@RequestBody Message message) {
		return service.save(message);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Message message) {
		service.delete(message);
	}
	
}
