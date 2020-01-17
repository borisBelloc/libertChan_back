package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.service.DiscussionThreadService;

import kaboni.libertchan.models.DiscussionThread;

@RestController
@RequestMapping("/discussionthreads")
public class DiscussionThreadController {

	@Autowired
	private DiscussionThreadService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DiscussionThread> findAll() {
		return service.findAll();
	}
	
}
