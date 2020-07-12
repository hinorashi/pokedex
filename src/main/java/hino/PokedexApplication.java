package hino;

import static hino.common.PokemonAbility.BLAZE;
import static hino.common.PokemonAbility.CURSED_BODY;
import static hino.common.PokemonAbility.DAMP;
import static hino.common.PokemonAbility.INNER_FOCUS;
import static hino.common.PokemonAbility.OVERGROW;
import static hino.common.PokemonAbility.SHELL_ARMOR;
import static hino.common.PokemonAbility.VOLT_ABSORB;
import static hino.common.PokemonAbility.WATER_ABSORB;
import static hino.common.PokemonType.DRAGON;
import static hino.common.PokemonType.ELECTRIC;
import static hino.common.PokemonType.FIGHTING;
import static hino.common.PokemonType.FIRE;
import static hino.common.PokemonType.FLYING;
import static hino.common.PokemonType.GHOST;
import static hino.common.PokemonType.GRASS;
import static hino.common.PokemonType.ICE;
import static hino.common.PokemonType.POISON;
import static hino.common.PokemonType.WATER;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import hino.dao.PokemonAbilityRepository;
import hino.dao.PokemonRepository;
import hino.dao.PokemonTypeRepository;
import hino.domain.Ability;
import hino.domain.Pokemon;
import hino.domain.Type;
import java.util.Arrays;
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

  @Autowired
  private PokemonTypeRepository pokemonTypeRepository;

  @Autowired
  private PokemonAbilityRepository pokemonAbilityRepository;

  public static void main(String[] args) {
    SpringApplication.run(PokedexApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      // type
      var water = Type.builder().name(WATER).build();
      var fighting = Type.builder().name(FIGHTING).build();
      var fire = Type.builder().name(FIRE).build();
      var flying = Type.builder().name(FLYING).build();
      var dragon = Type.builder().name(DRAGON).build();
      var electric = Type.builder().name(ELECTRIC).build();
      var grass = Type.builder().name(GRASS).build();
      var ice = Type.builder().name(ICE).build();
      var poison = Type.builder().name(POISON).build();
      var ghost = Type.builder().name(GHOST).build();

      // ability
      var damp = Ability.builder().name(DAMP).description("Prevents the use of self-destructing moves.").build();
      var waterAbsorb = Ability.builder().name(WATER_ABSORB).description("Restores HP if hit by a Water-type move.").build();
      var blaze = Ability.builder().name(BLAZE).description("Powers up Fire-type moves when the Pokémon is in trouble.").build();
      var innerFocus = Ability.builder().name(INNER_FOCUS).description("Protects the Pokémon from flinching.").build();
      var voltAbsorb = Ability.builder().name(VOLT_ABSORB).description("Restores HP if hit by an Electric-type move.").build();
      var overgrow = Ability.builder().name(OVERGROW).description("Powers up Grass-type moves when the Pokémon is in trouble.").build();
      var shellArmor = Ability.builder().name(SHELL_ARMOR).description("Protects the Pokémon from critical hits.").build();
      var cursedBody = Ability.builder().name(CURSED_BODY).description("May disable a move used on the Pokémon.").build();

      // pokemon
      var poliwrath = Pokemon.builder().id(62).name("Poliwrath").stat(510).build();
      poliwrath.addType(water);
      poliwrath.addType(fighting);
      poliwrath.addAbility(damp);
      poliwrath.addAbility(waterAbsorb);

      var charizard = Pokemon.builder().id(6).name("Charizard").stat(534).build();
      charizard.addType(fire);
      charizard.addType(flying);
      charizard.addAbility(blaze);

      var dragonite = Pokemon.builder().id(149).name("Dragonite").stat(600).build();
      dragonite.addType(dragon);
      dragonite.addType(flying);
      dragonite.addAbility(innerFocus);

      var jolteon = Pokemon.builder().id(135).name("Jolteon").stat(525).build();
      jolteon.addType(electric);
      jolteon.addAbility(voltAbsorb);

      var meganium = Pokemon.builder().id(154).name("Meganium").stat(525).build();
      meganium.addType(grass);
      meganium.addAbility(overgrow);

      var lapras = Pokemon.builder().id(131).name("Lapras").stat(535).build();
      lapras.addType(water);
      lapras.addType(ice);
      lapras.addAbility(waterAbsorb);
      lapras.addAbility(shellArmor);

      var gengar = Pokemon.builder().id(94).name("Gengar").stat(500).build();
      gengar.addType(poison);
      gengar.addType(ghost);
      gengar.addAbility(cursedBody);

      // persist
      pokemonTypeRepository.saveAll(Arrays.asList(water, fighting, fire, flying, dragon, electric, grass, ice, poison, ghost));
      pokemonAbilityRepository.saveAll(Arrays.asList(damp, waterAbsorb, blaze, innerFocus, voltAbsorb, overgrow, shellArmor, cursedBody));
      pokemonRepository.saveAll(Arrays.asList(poliwrath, charizard, dragonite, jolteon, meganium, lapras, gengar));

      log.info("It's up and running :)");
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
