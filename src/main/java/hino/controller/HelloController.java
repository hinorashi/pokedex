package hino.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "hello", description = "Say hello", protocols = "http")
@RestController
@RequestMapping(path = "/")
public class HelloController {

  @ApiOperation(value = "This is how we say hello in Zaun!", notes = "Nothing to note...", response = String.class)
  @GetMapping
  public ResponseEntity<String> index() throws IOException {
    return ResponseEntity.ok("Greetings from Hino! "
        + "<br>Here is your Inet Address: " + InetAddress.getLocalHost()
        + "<br>I think you should check the time: <span style=\"color:red\">"
        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
        + "</span>"
        + "<br>Take a look at the pokedex: <a style=\"color:red\" href=\"/pokemons/\">pokemons/</a>");
  }

  @GetMapping("/health")
  public ResponseEntity<String> healthcheck() {
    return ResponseEntity.ok().build();
  }
}
