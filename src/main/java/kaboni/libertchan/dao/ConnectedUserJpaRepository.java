package kaboni.libertchan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Role;

@Repository
public interface ConnectedUserJpaRepository extends JpaRepository<ConnectedUser, Long> {
	public Optional<ConnectedUser> findByEmail(String email);
	
	public List<ConnectedUser> findByIp(String ip);

	public List<ConnectedUser> searchUser(String mainPseudo, String password, String email, Role admin);

	public Optional<ConnectedUser> findByMainPseudo(String mainPseudo);
}
