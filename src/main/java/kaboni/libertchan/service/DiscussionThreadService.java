package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.DiscussionThreadJpaRepository;
import kaboni.libertchan.models.Channel;
import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;

@Service
public class DiscussionThreadService {
	
	@Autowired
	private DiscussionThreadJpaRepository repository;
	
	public List<DiscussionThread> findAll(){
		return repository.findAll();
	}
	
//	public List<DiscussionThread> findAllByOrderByDateDesc() {
//		return repository.findAllByOrderByDateDesc();
//	}
	
	
	public Optional<DiscussionThread> findByThreadId(Long id) {
		return repository.findById(id);
	}
	
	public List<DiscussionThread> findByChannel(Channel channel){
		return repository.findByChannel(channel);
	}
	
	public DiscussionThread save(DiscussionThread discussionThread) {
		discussionThread.getMessages().forEach(m ->
			m.setDiscussionThread(discussionThread)
		);
		return repository.save(discussionThread);
	}
	
	public void delete(DiscussionThread discussionThread) {
		repository.delete(discussionThread);
	}
	
	

}
