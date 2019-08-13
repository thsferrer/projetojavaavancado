package br.biblioteca.livros.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/h2-console").permitAll();
        http.headers().frameOptions().disable();

		http
		 .authorizeRequests()
		 .antMatchers(HttpMethod.GET, "/user/registration").permitAll()
		  	.antMatchers(HttpMethod.POST, "/user/registration").permitAll()
		 .antMatchers(HttpMethod.GET, "/user/list").hasRole("BASIC")
		  .antMatchers(HttpMethod.GET, "/user/listadmin").hasRole("ADMIN")
                .antMatchers("/user/form**").permitAll()
		  .and()
		  .formLogin()
				.loginPage("/login")
				.permitAll()
		 .and().logout()
				.logoutSuccessUrl("/")
				.permitAll()
            .and().requestCache();

	}

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
