package kaboni.libertchan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ConnectedUserJpaRepository;
import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Right;

@Service
public class ConnectedUserSecurityService implements UserDetailsService {

	@Autowired
	private ConnectedUserJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String mainPseudo) throws UsernameNotFoundException {

		Objects.requireNonNull(mainPseudo);
		ConnectedUser user = userRepository.findByMainPseudo(mainPseudo)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		/*List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		for (Right right : user.getRole().getRights()) {
			authorities.add(new SimpleGrantedAuthority(right.getLabel().toUpperCase()));
		}*/

		//return new User(user.getMainPseudo(), user.getPassword(), authorities);
		return user;
	}

}
