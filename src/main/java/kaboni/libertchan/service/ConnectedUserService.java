package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import exception.AlreadyExistsException;
import javassist.NotFoundException;
import kaboni.libertchan.dao.ConnectedUserJpaRepository;
import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Role;

@Service
public class ConnectedUserService {
	
	@Autowired
	private ConnectedUserJpaRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<ConnectedUser> findByEmail(String email) {
		return repository.findByEmail(email);

	}
	
	public ConnectedUser findById(Long id) throws NotFoundException{
		return repository.findById(id).orElseThrow(() -> new NotFoundException("User doesn't exist. (id = " + id + ")"));
	}
	
	public List<ConnectedUser> findAll(){
		return repository.findAll();
	}
	
	public ConnectedUser create(ConnectedUser user) throws AlreadyExistsException {
		if (user.getId() != null) {
			throw new AlreadyExistsException("Can't save. User has an id : " + user.getId());
		}

		encodePassword(user);
		
		return repository.save(user);
	}
	public ConnectedUser changePassword(Long id, String password) throws NotFoundException {
		ConnectedUser user = repository.findById(id)
			.orElseThrow(() -> new NotFoundException("User doesn't exist. (id = " + id + ")"));
		
		user.setPassword(password);

		encodePassword(user);
		
		return repository.save(user);
	}
	
	public ConnectedUser delete(Long id) throws NotFoundException {
		ConnectedUser baseUser = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("User doesn't exist. (id = " + id + ")"));
		repository.deleteById(id);
		return baseUser;
	}
	
	

	
	 
	private void encodePassword(ConnectedUser user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}

	
	
}
