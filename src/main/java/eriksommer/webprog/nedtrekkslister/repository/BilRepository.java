package eriksommer.webprog.nedtrekkslister.repository;

import eriksommer.webprog.nedtrekkslister.model.Bil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BilRepository {
    private final ArrayList<Bil> billiste = new ArrayList<>();

    public BilRepository() {
        this.billiste.add(new Bil("Audi", "R8 V10+"));
        this.billiste.add(new Bil("Audi", "RS4"));
        this.billiste.add(new Bil("Audi", "A3"));
        this.billiste.add(new Bil("Porche", "Tycan Turbo s"));
        this.billiste.add(new Bil("Porche", "911"));
        this.billiste.add(new Bil("Volvo", "XC90"));
        this.billiste.add(new Bil("Volvo", "XC60"));
        this.billiste.add(new Bil("Volvo", "XC40"));
        this.billiste.add(new Bil("Tesla", "Cyber Truck"));
        this.billiste.add(new Bil("Tesla", "Model 3"));
        this.billiste.add(new Bil("Tesla", "Model S"));
    }

    public void leggInn(Bil motorvogn) {
        billiste.add(motorvogn);
    }

    public ArrayList<Bil> hentAlle() {
        return billiste;
    }

    public void slettAlle() {
        billiste.clear();
    }
}
