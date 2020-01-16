package kaboni.libertchan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.service.ConnectedUserService;

@RestController
@RequestMapping("/api/users")
public class ConnectedUserController {

	@Autowired
	private ConnectedUserService service;
	
	@GetMapping("/email/{email}")
	public ConnectedUser findByEmail(@PathVariable String email) {
		return service.findByEmail(email).orElse(null);
	}
	
}
