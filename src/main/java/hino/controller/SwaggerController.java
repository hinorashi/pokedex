package hino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore // @Api(hidden = true) not gonna work
@Controller
@RequestMapping({"/swagger", "/swag"})
public class SwaggerController {

  @GetMapping
  public String swagger() {
    return "redirect:/swagger-ui.html";
  }
}
