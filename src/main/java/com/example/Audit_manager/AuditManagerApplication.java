package com.example.Audit_manager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.Audit_manager.audit.*;




@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditManagerApplication {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(AuditManagerApplication.class, args);
	}

}
