package kaboni.libertchan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import exception.AlreadyExistsException;
import kaboni.libertchan.dao.RightJpaRepository;
import kaboni.libertchan.dao.RoleJpaRepository;
import kaboni.libertchan.models.ConnectedUser;
import kaboni.libertchan.models.Right;
import kaboni.libertchan.models.Role;
import kaboni.libertchan.service.ConnectedUserService;

@Component
public class initializeData {
private static final Logger LOG = LoggerFactory.getLogger(initializeData.class);
	
	@Autowired
	private RightJpaRepository rightRepository;
	
	@Autowired
	private RoleJpaRepository roleRepository;
	
	@Autowired
	private ConnectedUserService connectedUserService;

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		// Rights creation
		
		Right readUsers = new Right("READ_USERS");
		Right createUsers = new Right("CREATE_USERS");
		Right deleteUsers = new Right("DELETE_USERS");
		Right grantJanitor = new Right("GRANT_JANITOR");
		Right grantModerator = new Right("GRANT_MODERATOR");
		
		
		rightRepository.save(readUsers);
		rightRepository.save(createUsers);
		rightRepository.save(deleteUsers);
		rightRepository.save(grantJanitor);
		rightRepository.save(grantModerator);

		// Roles creation
		Role admin = new Role("ADMIN");
		admin.addRight(readUsers);
		admin.addRight(createUsers);
		admin.addRight(deleteUsers);
		admin.addRight(grantJanitor);
		admin.addRight(grantModerator);
		
		
		
		
		Role moderator = new Role("MODERATOR");
		moderator.addRight(readUsers);
		moderator.addRight(createUsers);
		moderator.addRight(deleteUsers);
		moderator.addRight(grantJanitor);
		
		
		Role janitor = new Role("JANITOR");
		janitor.addRight(readUsers);
		janitor.addRight(createUsers);
		janitor.addRight(deleteUsers);
		
		Role user = new Role("USER");
		user.addRight(readUsers);
		user.addRight(createUsers);
		
		roleRepository.save(admin);
		roleRepository.save(moderator);
		roleRepository.save(janitor);
		roleRepository.save(user);
		
		// Users creation
		ConnectedUser adminUser = new ConnectedUser("admin", "password", "jl.adminne@ss.de", admin);
		ConnectedUser moderatorUser = new ConnectedUser("moderator", "password", "jl.modeau@ss.de", moderator);
		ConnectedUser janitornUser = new ConnectedUser("janitor", "password", "jl.adminne@ss.fr", janitor);
		ConnectedUser standardUser = new ConnectedUser("user", "password", "jl.illouzeurt@ss.de", user);

	/*	try {
			connectedUserService.create(adminUser);
			connectedUserService.create(moderatorUser);
			connectedUserService.create(janitornUser);
			connectedUserService.create(standardUser);
		} catch (AlreadyExistsException e) {
			LOG.warn("Unable to initialize data, users already exist.");
	*/	}
		
	
}
