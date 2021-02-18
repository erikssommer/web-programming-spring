package eriksommer.webprog.klientTjener1.controller;

import eriksommer.webprog.klientTjener1.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/klienttjener1")
public class TempController {

    @Autowired
    TempService service;

    @GetMapping("/hentTemp")
    public int calculate(String mnd) {
        return service.getTemp(mnd);
    }

}
