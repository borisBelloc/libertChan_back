package kaboni.libertchan.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BannedUser {
	@Repository
	public interface BannedUserJpaRepository extends JpaRepository<BannedUser, Integer> {
		public Optional<kaboni.libertchan.models.BannedUser> findByIp(String Ip);
	}

}
