package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ChannelJpaRepository;
import kaboni.libertchan.models.Channel;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelJpaRepository repository;
	
	public Optional<Channel> findById(Long id) {
		return repository.findById(id);
	}
	

	public List<Channel> findAll() {
		return repository.findAll();
	}
	
	public Channel save(Channel channel) {
		return repository.save(channel);
	}
	
	public void delete(Channel channel) {
		repository.delete(channel);
	}
	
	public Optional<Channel> findByShortName(String shortName) {
		return repository.findByShortName(shortName);
	}

}
