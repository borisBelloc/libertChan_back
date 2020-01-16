package kaboni.libertchan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ConnectedUserJpaRepository;
import kaboni.libertchan.models.ConnectedUser;

@Service
public class ConnectedUserService {
	
	@Autowired
	private ConnectedUserJpaRepository repository;
	
	public Optional<ConnectedUser> findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
