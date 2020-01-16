package kaboni.libertchan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.BannedUser.BannedUserJpaRepository;
import kaboni.libertchan.models.BannedUser;
import kaboni.libertchan.models.ConnectedUser;

@Service
public class BannedUserService {
	@Autowired
	private BannedUserJpaRepository repository;
	
	public Optional<BannedUser> findByIp(String ip) {
		return repository.findByIp(ip);
	}

}
