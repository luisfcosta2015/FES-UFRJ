package merenda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import merenda.repository.UsuarioRepository;
import merenda.service.PadraoUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
@EnableWebSecurity
public class Seguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PadraoUserDetailsService userDetailsService;
	String[] resources = new String[] { 
			"/","/css/**","/icons/**","/images/**","/js/**","/fonts/**","/vendor/**", "/webjars/**"};
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			  .antMatchers(resources).permitAll()
			  .anyRequest().authenticated()
			  .and()
			.formLogin()
			  .loginPage("/login").permitAll()
			  .and()
			.logout().permitAll();
	}
	
}
