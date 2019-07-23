package hino.controller;

import java.io.IOException;
import java.net.InetAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  public ResponseEntity<String> index() throws IOException {
    return ResponseEntity.ok("Greetings from Hino!<br>Here is your Inet Address: " + InetAddress.getLocalHost());
  }
}
