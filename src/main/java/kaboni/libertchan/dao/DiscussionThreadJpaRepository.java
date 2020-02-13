package kaboni.libertchan.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.DiscussionThread;

@Repository
public interface DiscussionThreadJpaRepository extends JpaRepository<DiscussionThread, Long> {

}
