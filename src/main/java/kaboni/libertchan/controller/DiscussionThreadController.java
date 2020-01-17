package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.service.DiscussionThreadService;

@RestController
@RequestMapping("/discussionthreads")
public class DiscussionThreadController {

	@Autowired
	private DiscussionThreadService service;
	
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
		return service.save(discussionThread);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable DiscussionThread discussionThread) {
		service.delete(discussionThread);
	}
	
}
