package ipn.mx.SystemHealth.SystemHealthF.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
    @Autowired
    UserDetailsService userDetailsService;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/vendor/**").permitAll()
			.antMatchers("/form").permitAll()
			.antMatchers("/sform").permitAll()
			.antMatchers("/paciente/**").hasRole("PAC")
			.antMatchers("/doctor/**").hasRole("DOC")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(customSuccessHandler)
				.permitAll()
			.and()
			.logout()
				.permitAll();
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	

}
