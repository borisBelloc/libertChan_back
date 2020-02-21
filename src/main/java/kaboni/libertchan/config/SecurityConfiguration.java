package kaboni.libertchan.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        .cors().and()
       
                .authorizeRequests()
                .antMatchers("/channels").permitAll()
                .antMatchers("/Channels/**").permitAll()
                .antMatchers("/login*").permitAll()

                .antMatchers("/role/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().successHandler(successHandler()).failureHandler(failureHandler()).and().logout().permitAll()
                .and().httpBasic() 
                
                .and().httpBasic().and().formLogin().permitAll()
                .and().logout().permitAll()
                
            ;}


   
 @Bean
	public PasswordEncoder createPasswordEncoderBean() {
		return new BCryptPasswordEncoder(10);
}
 
 @Bean
	public WebMvcConfigurer configurer(){
	  return new WebMvcConfigurer(){
		  
		  
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	      registry.addMapping("/**")
	          .allowedOrigins("*").allowCredentials(true);
	    }
	  };
 }
  
    
 public AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_OK);
			}
		};
 }
		public AuthenticationFailureHandler failureHandler() {
			return new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			};
		}
	
  @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(createPasswordEncoderBean());
}
	 }
 
    
    
