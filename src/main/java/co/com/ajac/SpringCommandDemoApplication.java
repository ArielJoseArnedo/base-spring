package co.com.ajac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.com.ajac")
public class SpringCommandDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCommandDemoApplication.class, args);
	}

}
