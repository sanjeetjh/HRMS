/**
 * 
 */
package in.sanjeetjh.hrms.authentication.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import in.sanjeetjh.hrms.authentication.provider.HRMSAuthenticationProvider;

/**
 * @author sanjeet
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	private HRMSAuthenticationProvider hrmsAuthenticationProvider;

	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	/*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}*/
	
	protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(hrmsAuthenticationProvider);
    }
	
	@Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
		.antMatchers(
                "/fonts/**",
                "/css/**",
                "/img/**",
                "/js/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username").passwordParameter("password").permitAll()
		.and().logout().deleteCookies("remember-me").logoutSuccessUrl("/login?logout")
		.and().rememberMe()
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().csrf();
	}

}
