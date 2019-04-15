package br.com.victor;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.victor.model.Client;
import br.com.victor.repository.ClientRepository;



@SpringBootApplication
public class Application {
	
	private static final Logger logger = Logger.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	public CommandLineRunner setup(ClientRepository clientRepository) {
		return (args) -> {
			clientRepository.save(new Client("Gustavo", "Ponce", "gustavo_ponce@teste.com","123@123ab"));
			clientRepository.save(new Client("John", "Smith", "john_smith@teste.com","123@123ab"));
			clientRepository.save(new Client("Jim ", "Morrison", "jim_morrison@teste.com","123@123ab"));
			clientRepository.save(new Client("David", "Gilmour", "david_gilmour@teste.com","123@123ab"));
			logger.info("The sample data has been generated");
		};
	}*/
}
