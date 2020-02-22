package kaboni.libertchan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Channel;
import kaboni.libertchan.models.DiscussionThread;

@Repository
public interface DiscussionThreadJpaRepository extends JpaRepository<DiscussionThread, Long> {

	List<DiscussionThread> findByChannel(Channel channel);
//	public Optional<DiscussionThread> findByThreadId(Long threadId);
	public List<DiscussionThread> findAllByOrderByDateDesc();
	List<DiscussionThread> findByChannelOrderByDateDesc(Channel channel);
}
