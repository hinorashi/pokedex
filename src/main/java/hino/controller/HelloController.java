package hino.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.net.InetAddress;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Say hello", protocols = "http")
@RestController
@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
public class HelloController {

  @ApiOperation(value = "This is how we say hello in Zaun!", notes = "Nothing to note...", response = String.class)
  @GetMapping("/")
  public ResponseEntity<String> index() throws IOException {
    return ResponseEntity.ok("Greetings from Hino!<br>Here is your Inet Address: " + InetAddress.getLocalHost());
  }
}
