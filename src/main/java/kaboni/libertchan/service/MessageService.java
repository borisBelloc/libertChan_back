package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.MessageJpaRepository;
import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;

@Service
public class MessageService {
	
	@Autowired
	private MessageJpaRepository repository;
	
	

	public List<Message> findAllByOrderByDateDesc() {
		return repository.findAllByOrderByDateDesc();
	}
	
	
	
	public Optional<Message> findByPostNumber(Long postNumber) {
		return repository.findByPostNumber(postNumber);
	}
	
	public Optional<Message> findById(Long id){
		return repository.findById(id);
	}
	
	public List<Message> findAll(){
		return repository.findAll();
	}
	
	public Message save(Message message) {
		return repository.save(message);
	}
	
	public void delete(Message message) {
		repository.delete(message);
	}



	public List<Message> findByDiscussionThread(DiscussionThread discussionThread) {
		// TODO Auto-generated method stub
		return repository.findByDiscussionThread(discussionThread);
	}
	
}
