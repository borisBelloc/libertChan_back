package kaboni.libertchan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import exception.NotFoundException;
import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.service.ConnectedUserService;

@Service
public class SecurityExpression {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurityExpression.class);

	@Autowired
	private ConnectedUserService UserService;
	
	public boolean isConnectedUser(Long id, UserDetails principal) {
		boolean authorized = false;
		
		try {
			ConnectedUser user = UserService.findById(id);
			authorized = user.getMainPseudo().equals(principal.getUsername());

		} catch (NotFoundException ) {
		}
		if (!authorized) {
			LOG.warn("Malicious attempt to modify a password (connected : " + principal.getUsername() + ", victim : " + id);
		}
		return authorized;
	}

	public boolean isConnectedUser(Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return isConnectedUser(id, ((UserDetails) authentication.getPrincipal()));
	}
	

	}
	
