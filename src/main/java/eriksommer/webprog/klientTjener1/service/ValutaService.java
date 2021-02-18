package eriksommer.webprog.klientTjener1.service;

import eriksommer.webprog.klientTjener1.hjelpeklasser.Belop;
import eriksommer.webprog.klientTjener1.hjelpeklasser.Valuta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ValutaService {

    private final ArrayList<Valuta> valutaRegister = new ArrayList<>();

    public void loadData(){
        Valuta sek = new Valuta("SEK", 0.85);
        Valuta usd = new Valuta("USD", 8.85);
        Valuta eur = new Valuta("EUR", 9.56);

        valutaRegister.add(sek);
        valutaRegister.add(usd);
        valutaRegister.add(eur);
    }

    public double beregn(Belop belop){
        for (Valuta valuta : valutaRegister){
            if (valuta.getSort().equals(belop.getSort())){
                return valuta.getKurs() * belop.getVerdi();
            }
        }
        return 0.0;
    }
}
