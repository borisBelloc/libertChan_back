package kaboni.libertchan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import kaboni.libertchan.config.FileStorageProperties;

@Configuration
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
@EnableConfigurationProperties({FileStorageProperties.class})
public class LibertchanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibertchanApplication.class, args);
	}

}
