package kaboni.libertchan.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.Channel;

@Repository
public interface ChannelJpaRepository extends JpaRepository<Channel, Long> {
	
	public Optional<Channel> findByShortName(String shortName);

}
