package eriksommer.webprog.nedtrekkslister.repository;

import eriksommer.webprog.nedtrekkslister.model.Motorvogn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MotorvognRepository {
    private final ArrayList<Motorvogn> motorvognliste = new ArrayList<>();

    public void leggInn(Motorvogn motorvogn) {
        motorvognliste.add(motorvogn);
    }

    public ArrayList<Motorvogn> hentAlle() {
        return motorvognliste;
    }

    public void slettAlle() {
        motorvognliste.clear();
    }
}
