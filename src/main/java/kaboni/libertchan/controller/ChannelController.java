package kaboni.libertchan.controller;

import java.nio.channels.Channel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class ChannelController {

	@Autowired
	private ChannelService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Channel> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Channel findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Channel save(@PathVariable Channel channel) {
		return service.save(channel);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Channel channel) {
		service.delete(channel);
	}
	
}
