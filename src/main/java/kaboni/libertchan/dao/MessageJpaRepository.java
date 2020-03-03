package kaboni.libertchan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.DiscussionThread;
import kaboni.libertchan.models.Message;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long> {
	public Optional<Message> findByPostNumber(Long postNumber);
	public List<Message> findAllByOrderByDateDesc();
	public List<Message> findByDiscussionThreadOrderByDateAsc(DiscussionThread discussionThread);

//	TODO: faire une methode <find last 5 messages> avec query definie: 
	// Utiliser 'limit +/-5' @Query("SELECT * FROM foo ORDER BY date ASC")
	
	@Query(value = "SELECT * FROM Message ORDER BY date DESC LIMIT :nbMessages", nativeQuery = true)
	public List<Message> findLastMessages(@Param("nbMessages") int nbMessages);
	
	@Query(value = "SELECT * FROM Message WHERE is_signaled = true", nativeQuery = true)
	public List<Message> findSignaled();

	
}
