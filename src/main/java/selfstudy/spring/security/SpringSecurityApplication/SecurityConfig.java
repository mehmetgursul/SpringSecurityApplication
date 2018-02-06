package selfstudy.spring.security.SpringSecurityApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/user/accounts/*").hasRole(USER).and().httpBasic();
		httpSecurity.authorizeRequests().antMatchers("/admin/accounts/*").hasRole(ADMIN).and().httpBasic();
		httpSecurity.authorizeRequests().antMatchers("/public/accounts/*").permitAll();		
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("marry").password("test").roles(USER);
		auth.inMemoryAuthentication().withUser("jane").password("test").roles(ADMIN);
	}

}
