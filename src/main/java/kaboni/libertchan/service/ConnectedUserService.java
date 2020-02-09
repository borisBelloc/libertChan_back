package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ConnectedUserJpaRepository;
import kaboni.libertchan.models.ConnectedUser;

@Service
public class ConnectedUserService {
	
	@Autowired
	private ConnectedUserJpaRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<ConnectedUser> findByEmail(String email) {
		return repository.findByEmail(email);

	}
	
	public Optional<ConnectedUser> findById(Long id){
		return repository.findById(id);
	}
	
	public List<ConnectedUser> findAll(){
		return repository.findAll();
	}

	
	
}
