package Sun.crud.res.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

	@EnableWebSecurity
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter  {	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/main","/board","/write").permitAll()
	                .anyRequest().authenticated()
	                .and()         
	            .logout()
	                .permitAll()
	            .and()
	            .csrf().disable(); // CSRF 비활성화
	    }

}
