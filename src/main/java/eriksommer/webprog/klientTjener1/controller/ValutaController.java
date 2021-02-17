package eriksommer.webprog.klientTjener1.controller;

import eriksommer.webprog.klientTjener1.hjelpeklasser.Belop;
import eriksommer.webprog.klientTjener1.hjelpeklasser.Valuta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/klienttjener1/")
public class ValutaController {

    private final ArrayList<Valuta> valutaRegister = new ArrayList<>();

    @PostMapping("/load")
    public void load(){
        Valuta sek = new Valuta("SEK", 0.85);
        Valuta usd = new Valuta("USD", 8.85);
        Valuta eur = new Valuta("EUR", 9.56);

        valutaRegister.add(sek);
        valutaRegister.add(usd);
        valutaRegister.add(eur);
    }

    @GetMapping("/beregnKurs")
    public double calculate(Belop belop){
        return 0.0;
    }
}
