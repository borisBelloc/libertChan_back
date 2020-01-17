package kaboni.libertchan.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.BannedUser;

@Repository
public interface BannedUserJpaRepository extends JpaRepository<BannedUser, Long> {
		public Optional<BannedUser> findByIp(String ip);
		public Optional<BannedUser> findById(Long id);
}