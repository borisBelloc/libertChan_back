package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.ReservedPseudo;
import kaboni.libertchan.service.ReservedPseudoService;

@RestController
@RequestMapping("/users/reserved")
public class ReservedPseudoController {
	
	@Autowired
	private ReservedPseudoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	 
		public List<ReservedPseudo> findAll(){
			return service.findAll();
			
		}
	
	@GetMapping("/pseudo/{pseudo}")
	public ReservedPseudo findByPseudo(@PathVariable String pseudo) {
		return service.findByPseudo(pseudo).orElse(null);
	}
	@GetMapping("/{id}")
	public ReservedPseudo findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	}


