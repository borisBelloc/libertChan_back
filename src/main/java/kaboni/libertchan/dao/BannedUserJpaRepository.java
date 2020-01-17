package kaboni.libertchan.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.BannedUser;



	@Repository
	public interface BannedUserJpaRepository extends JpaRepository<BannedUser, Integer> {
		public Optional<kaboni.libertchan.models.BannedUser> findByIp(String ip);
		public Optional<kaboni.libertchan.models.BannedUser> findById(long id);
		public List<BannedUser> findAll();
	}


