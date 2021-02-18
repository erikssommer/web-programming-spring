package eriksommer.webprog.klientTjener1.service;

import eriksommer.webprog.klientTjener1.hjelpeklasser.Belop;
import eriksommer.webprog.klientTjener1.hjelpeklasser.Valuta;

import java.util.ArrayList;

public class Service {
    public double beregn(ArrayList<Valuta> valutaRegister, Belop belop){
        for (Valuta valuta : valutaRegister){
            if (valuta.getSort().equals(belop.getSort())){
                return valuta.getKurs() * belop.getVerdi();
            }
        }
        return 0.0;
    }
}
