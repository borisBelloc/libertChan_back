package kaboni.libertchan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.service.DiscussionThreadService;
import kaboni.libertchan.service.ImageService;
import kaboni.libertchan.service.MessageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/discussionthreads")
public class DiscussionThreadController {

	@Autowired
	private DiscussionThreadService service;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ImageService imageService;
	
	private static final Logger LOG = LoggerFactory.getLogger(DiscussionThreadController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DiscussionThread> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public DiscussionThread findById(@PathVariable Long id) {
		return service.findByThreadId(id).orElse(null);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public DiscussionThread save(@RequestBody DiscussionThread discussionThread) {
		LOG.warn("création d'un topic");
		return service.save(discussionThread);
	}
	
	
	/*@RequestMapping(method = RequestMethod.POST)
	public DiscussionThread save(@RequestBody DiscussionThread discussionThread) {
		LOG.warn("création d'un topic");
		for(Message message : discussionThread.getMessages()) {
			//LOG.warn(message.toString());
			message.setImage(imageService.save(message.getImage()));
			messageService.save(message);
		}

		return service.save(discussionThread);
	}
	*/
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable DiscussionThread discussionThread) {
		service.delete(discussionThread);
	}
	
}
