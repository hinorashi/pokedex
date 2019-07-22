package hino;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class PokedexApplication {

  public static void main(String[] args) {
    SpringApplication.run(PokedexApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      log.info("You know it's running :)");
    };
  }
}
