package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.Role;
import kaboni.libertchan.service.RoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	
	@Autowired
	private RoleService service;
	
	@PreAuthorize("hasAuthority('SELECT_ROLE')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Role> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Role findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	@PreAuthorize("hasAuthority('CREATE_ROLE')")
	@RequestMapping(method = RequestMethod.POST)
	public Role save(@RequestBody Role role) {
		return service.save(role);
	}
	@PreAuthorize("hasAuthority('DELETE_ROLE')")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Role role) {
		service.delete(role);
	}
	
}
