package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.DiscussionThreadJpaRepository;
import kaboni.libertchan.models.DiscussionThread;

@Service
public class DiscussionThreadService {
	
	@Autowired
	private DiscussionThreadJpaRepository repository;
	
	public List<DiscussionThread> findAll(){
		return repository.findAll();
	}
	
	public Optional<DiscussionThread> findByThreadId(Long id) {
		return repository.findById(id);
	}
	
	public DiscussionThread save(DiscussionThread discussionThread) {
		return repository.save(discussionThread);
	}
	
	public void delete(DiscussionThread discussionThread) {
		repository.delete(discussionThread);
	}

}
