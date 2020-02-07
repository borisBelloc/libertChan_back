package kaboni.libertchan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import kaboni.libertchan.dao.RightJpaRepository;
import kaboni.libertchan.dao.RoleJpaRepository;
import kaboni.libertchan.models.Right;
import kaboni.libertchan.models.Role;
import kaboni.libertchan.service.ConnectedUserService;

@Component
public class initalizeData {
private static final Logger LOG = LoggerFactory.getLogger(InitializeData.class);
	
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
		
		rightRepository.save(readUsers);
		rightRepository.save(createUsers);
		rightRepository.save(deleteUsers);

		// Roles creation
		Role admin = new Role("ADMIN");
		admin.addRight(readUsers);
		admin.addRight(createUsers);
		admin.addRight(deleteUsers);
		
		Role moderator = new Role("MODERATOR");
		moderator.addRight(readUsers);
		moderator.addRight(createUsers);
		
		Role user = new Role("USER");
		user.addRight(readUsers);
		
		roleRepository.save(admin);
		roleRepository.save(moderator);
		roleRepository.save(user);
		
		// Users creation
		User adminUser = new User("admin", "password", "Jean-Luc", "Adminne", "jl.adminne@ss.de", admin);
		User moderatorUser = new User("moderator", "password", "Jean-Luc", "Modeau", "jl.modeau@ss.de", moderator);
		User standardUser = new User("user", "password", "Jean-Luc", "Illouzeurt", "jl.illouzeurt@ss.de", user);

		try {
			userService.create(adminUser);
			userService.create(moderatorUser);
			userService.create(standardUser);
		} catch (AlreadyExistsException e) {
			LOG.warn("Unable to initialize data, users already exist.");
		}
	}
}
