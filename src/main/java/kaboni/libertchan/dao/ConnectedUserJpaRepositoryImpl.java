package kaboni.libertchan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Role;

@Repository
public class ConnectedUserJpaRepositoryImpl implements ConnectedUserJpaRepositoryCustom {

	
	@Override
	public List<ConnectedUser> searchUser(String mainPseudo, String password, String email, Role admin) {
		return null;
	}
}
