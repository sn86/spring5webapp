package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
//@ComponentScan({"guru.springframework.spring5webapp"})
//required to find entity classes 
//@EntityScan({"guru.springframework.spring5webapp.model"} )
//Autowiring doesnt work on jparepository extended
//@EnableJpaRepositories(basePackages = {"guru.springframework.spring5webapp.repository"})
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
