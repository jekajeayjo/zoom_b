package md.zoom;

import md.kobalt.security.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@AutoConfiguration
@Import({ ApplicationConfig.class })
public class ZoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoomApplication.class, args);
	}

}
