package kaboni.libertchan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
public class LibertchanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibertchanApplication.class, args);
	}

}
