package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.RoleJpaRepository;
import kaboni.libertchan.models.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleJpaRepository repository;
	
	public Optional<Role> findById(Long id){
		return repository.findById(id);
	}
	
	public List<Role> findAll(){
		return repository.findAll();
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}
	
	public void delete(Role role) {
		repository.delete(role);
	}

}
