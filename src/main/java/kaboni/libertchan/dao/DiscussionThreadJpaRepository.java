package kaboni.libertchan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Channel;
import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;

@Repository
public interface DiscussionThreadJpaRepository extends JpaRepository<DiscussionThread, Long> {

	List<DiscussionThread> findByChannel(Channel channel);
//	public Optional<DiscussionThread> findByThreadId(Long threadId);
	public List<DiscussionThread> findAllByOrderByDateDesc();
	List<DiscussionThread> findByChannelOrderByDateDesc(Channel channel);
}
