package hino;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import hino.dao.PokemonRepository;
import hino.dao.PokemonRepositoryCustom;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class PokedexApplication {

  @Autowired
  private PokemonRepository pokemonRepository;

  public static void main(String[] args) {
    SpringApplication.run(PokedexApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      log.info("You know it's running :)");
      pokemonRepository.saveAll(PokemonRepositoryCustom.pokemonList);
    };
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("hino.controller"))
        // .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/*"))
        // .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false)// override default response message
        .globalResponseMessage(
            RequestMethod.GET,
            Collections.singletonList(new ResponseMessageBuilder()
                .code(HttpStatus.I_AM_A_TEAPOT.value())
                .message("I'm NOT a teapot!")
                .build())
        );
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Pokedex REST API",
        "Enjoy your pokedex!",
        "6.9",
        "http://example.com/",
        new Contact("Hino", "https://gitlab.com/hino-hatake", "sinhngay3110@gmail.com"),
        "Licence: WTFPL",
        "http://www.wtfpl.net/txt/copying/",
        Collections.emptyList());
  }

  @Bean
  public com.fasterxml.jackson.databind.Module datatypeHibernateModule() {
    return new Hibernate5Module();
  }
}
