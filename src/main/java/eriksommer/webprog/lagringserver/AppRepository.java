package eriksommer.webprog.lagringserver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Repository
public class AppRepository {
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
