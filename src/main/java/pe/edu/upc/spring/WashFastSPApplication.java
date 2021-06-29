package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WashFastSPApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
	public static void main(String[] args) {
		SpringApplication.run(WashFastSPApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String passwordAdmin = "admin";
		String passwordCliente = "cliente";
		String passwordRepartidor = "repartidor";
		
			for(int i=0; i<2;i++) {
			
				String bycryptPassword = passwordEncoder.encode(passwordAdmin);
				System.out.println(bycryptPassword);
			}
		
			for(int i=0; i<2;i++) {
				String bycryptPassword = passwordEncoder.encode(passwordCliente);
				System.out.println(bycryptPassword);
			}
			
			for(int i=0; i<2;i++) {
				String bycryptPassword = passwordEncoder.encode(passwordRepartidor);
				System.out.println(bycryptPassword);
			}	
	}

}
