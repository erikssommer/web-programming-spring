package eriksommer.webprog.klientTjener1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServerController {

    @GetMapping("/helloserver")
    public String hello(String name) {
        return "Hallo fra " + name;
    }
}
