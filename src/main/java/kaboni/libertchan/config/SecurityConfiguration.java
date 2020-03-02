package kaboni.libertchan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kaboni.libertchan.service.ConnectedUserSecurityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ConnectedUserSecurityService userSecurityService;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
          .password("pass")
          .roles("USER");
    */
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
       
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic().and().formLogin().and().logout().permitAll()
                
                ;}


   
 @Bean
	public PasswordEncoder createPasswordEncoderBean() {
		return new BCryptPasswordEncoder(10);
}
  
    
   @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(createPasswordEncoderBean());
}
}

