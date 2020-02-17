package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.Channel;
import kaboni.libertchan.service.ChannelService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/channels")
public class ChannelController {

	@Autowired
	private ChannelService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Channel> findAll() {
		return service.findAll();
	}
	
	/*
	@GetMapping("/{id}")
	public Channel findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	*/
	
	@PreAuthorize("hasAuthority('CREATE_CHANNEL')")
	@RequestMapping(method = RequestMethod.POST)
	public Channel save(@PathVariable Channel channel) {
		return service.save(channel);
	}
	
	@PreAuthorize("hasAuthority('DELETE_CHANNEL')")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Channel channel) {
		service.delete(channel);
	}
	
	@GetMapping("/{shortName}")
	public Channel findByShortName(@PathVariable String shortName) {
		return service.findByShortName(shortName).orElse(null);
	}
	
}
