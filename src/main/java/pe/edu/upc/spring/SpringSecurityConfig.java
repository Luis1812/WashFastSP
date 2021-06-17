package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginSuccessHandler successHandler;
	
	protected void configure(HttpSecurity http) throws Exception{
		try {
			// ROLE_ADMIN , ROLE_CLIENTE , ROLE_REPARTIDOR 
			http.authorizeRequests()
				.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE') or hasRole('ROLE_REPARTIDOR')")
				.antMatchers("/administrador/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/cliente/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/detalle/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE') or hasRole('ROLE_REPARTIDOR')")
				.antMatchers("/local/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/metodopago/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/pedido/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE') or hasRole('ROLE_REPARTIDOR')")
				.antMatchers("/prenda/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/reclamo/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/repartidor/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/servicio/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/usuario/**").access("hasRole('ROLE_ADMIN')").and()
				.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
						
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		
	}
	
	
}
