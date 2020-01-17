package kaboni.libertchan.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.ConnectedUser;

@Repository
public interface ConnectedUserJpaRepository extends JpaRepository<ConnectedUser, Long> {
	public Optional<ConnectedUser> findByEmail(String email);
}
