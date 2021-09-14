package sjy.jaengsplay.api.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JaengsplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaengsplayApplication.class, args);
    }

}
