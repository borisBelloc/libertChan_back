package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.service.ConnectedUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class ConnectedUserController {

	@Autowired
	private ConnectedUserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConnectedUser> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/api/email/{email}/")
	public ConnectedUser findByEmail(@PathVariable String email) {
		return service.findByEmail(email).orElse(null);
	}
	
	@GetMapping("/{id}")
	public ConnectedUser findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
}
