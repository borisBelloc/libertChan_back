package kaboni.libertchan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exception.NotFoundException;
import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.service.ConnectedUserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class ConnectedUserController {
	
	
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public ConnectedUser validateLogin() {
		return new ConnectedUser("User successfully authenticated");
	}

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
	public ConnectedUser findById(@PathVariable Long id) throws NotFoundException {
		return service.findById(id);
	}
	@PutMapping("/{id}/password")
	@PreAuthorize("hasRole('ADMIN') or @securityExpression.isConnectedUser(#id)")
	public void changePassword(@PathVariable Long id, @RequestParam String password) throws NotFoundException {
		service.changePassword(id, password);
	}
	
	@PreAuthorize("hasAuthority('SELECT_IP')")
	@GetMapping("/ip/{ip}")
	public ConnectedUser findByIp(@PathVariable String ip) {
		return service.findByIp(ip).orElse(null);
	}

	
}
