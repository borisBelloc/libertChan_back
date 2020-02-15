package kaboni.libertchan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.Channel;
import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;
import kaboni.libertchan.service.ChannelService;
import kaboni.libertchan.service.DiscussionThreadService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/discussionthreads")
public class DiscussionThreadController {

	@Autowired
	private DiscussionThreadService service;
	
	@Autowired
	private ChannelService channelService;
	
	private static final Logger LOG = LoggerFactory.getLogger(DiscussionThreadController.class);
	
//	@GetMapping("/all")
	@RequestMapping(method = RequestMethod.GET)
	public List<DiscussionThread> findAll() {
		return service.findAll();
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<DiscussionThread> findAllByOrderByDateDesc() {
//		return service.findAllByOrderByDateDesc();
//	}
	
	
	@GetMapping("/channel/{channelName}")
	public List<DiscussionThread> findByChannel(@PathVariable String channelName) {
		Channel associateChannel = channelService.findByShortName(channelName).orElse(null);
		return service.findByChannel(associateChannel);
	}
	
	@GetMapping("/{id}")
	public DiscussionThread findById(@PathVariable Long id) {
		return service.findByThreadId(id).orElse(null);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public DiscussionThread save(@RequestBody DiscussionThread discussionThread, @RequestParam String channel) {
		LOG.warn("création d'un topic");
		Channel associateChannel = channelService.findByShortName(channel).orElse(null);
		discussionThread.setChannel(associateChannel);
		return service.save(discussionThread);
	}
	
	@PreAuthorize("hasAuthority('DELETE_THREAD')")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable DiscussionThread discussionThread) {
		service.delete(discussionThread);
	}
	
}
