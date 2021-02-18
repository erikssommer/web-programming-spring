package eriksommer.webprog.klientTjener1.service;

import org.springframework.stereotype.Service;

@Service
public class KalkulatorService {

    public double addere(double tall1, double tall2) throws Exception { // Usikker på hvilket avvik som kastes -> safe
        return tall1 + tall2;
    }

    public double subtrahere(double tall1, double tall2) throws Exception {
        return tall1 - tall2;
    }

    public double multiplisere(double tall1, double tall2) throws Exception {
        return tall1 * tall2;
    }

    public double dividere(double tall1, double tall2) throws Exception {
        return tall1 / tall2;
    }
}
