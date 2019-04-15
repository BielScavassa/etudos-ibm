package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ibm.user.repository")
@SpringBootApplication
public class SpringHibernateAulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateAulaApplication.class, args);
	}

}
