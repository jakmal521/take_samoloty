package pl.polsl.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<SpringBootApplication> applicationClass = SpringBootApplication.class;

}
