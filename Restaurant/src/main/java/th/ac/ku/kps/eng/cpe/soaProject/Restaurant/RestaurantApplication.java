package th.ac.ku.kps.eng.cpe.soaProject.Restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication

@ComponentScan("th.ac.ku.kps.eng.cpe.soaProject")

@EnableJpaRepositories("th.ac.ku.kps.eng.cpe.soaProject.repository")
public class RestaurantApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return     builder.sources(RestaurantApplication.class);
    }
}
