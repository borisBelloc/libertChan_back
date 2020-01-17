package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.BannedUser;

import kaboni.libertchan.service.BannedUserService;

@RestController
@RequestMapping("/api/users/banned")
public class BannedUserController {

	@Autowired
	private BannedUserService service;

	@GetMapping("/ip/{ip}")
	public BannedUser findByIp(@PathVariable String ip) {
		return service.findByIp(ip).orElse(null);
	}

	@GetMapping("/{id}")
	public BannedUser findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}

}
