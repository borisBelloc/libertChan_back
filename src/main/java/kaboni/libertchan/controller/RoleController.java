package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.Role;
import kaboni.libertchan.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	
	@Autowired
	private RoleService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Role> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Role findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Role save(@RequestBody Role role) {
		return service.save(role);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Role role) {
		service.delete(role);
	}
	
}
