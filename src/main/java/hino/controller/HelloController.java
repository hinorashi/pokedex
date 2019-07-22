package hino.controller;

import java.io.IOException;
import java.net.InetAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  public String index() throws IOException {
    return "Greetings from Hino!<br>Here is your Inet Address: " + InetAddress.getLocalHost();
  }
}
