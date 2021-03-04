package eriksommer.webprog.klientTjener1.controller;

import eriksommer.webprog.klientTjener1.model.Belop;
import eriksommer.webprog.klientTjener1.service.ValutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/klienttjener1/")
public class ValutaController {

    @Autowired
    ValutaService valutaService;

    @PostMapping("/load")
    public void load(){
        valutaService.loadData();
    }

    @GetMapping("/beregnKurs")
    public double calculate(Belop belop){
        return valutaService.beregn(belop);
    }
}
