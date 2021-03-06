package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.BannedUserJpaRepository;
import kaboni.libertchan.models.BannedUser;


@Service
public class BannedUserService {
	
	@Autowired
	private BannedUserJpaRepository repository;
	
	public Optional<BannedUser> findByIp(String ip) {
		return repository.findByIp(ip);
	}
	
	public Optional<BannedUser> findById(Long id){
		return repository.findById(id);
	}

	public List<BannedUser> findAll() {
		
		return repository.findAll();
	}
	
	

}
