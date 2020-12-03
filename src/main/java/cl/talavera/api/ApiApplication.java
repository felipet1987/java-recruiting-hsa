package cl.talavera.api;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.data.CategoryResponse;
import cl.talavera.api.data.CategoryRestRepository;
import cl.talavera.api.data.CouponResponse;
import cl.talavera.api.data.CouponRestRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootApplication
public class ApiApplication {
	private static final Logger log = LoggerFactory.getLogger(ApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

@Component
class ApplicationRunner implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		//use this to run functional test!!
		System.out.println("Welcome!!!");
	}
}




