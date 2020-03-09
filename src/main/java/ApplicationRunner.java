import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "common",
        "controller",
        "service",
        "repository",
        "model",
})
@EntityScan("repository")
@EnableAutoConfiguration
public class ApplicationRunner {

        public static void main(String[] args) {
            SpringApplication.run(ApplicationRunner.class, args);
        }

    }
