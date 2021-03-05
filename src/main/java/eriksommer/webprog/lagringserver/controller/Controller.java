package eriksommer.webprog.lagringserver.controller;

import eriksommer.webprog.lagringserver.model.Motorvogn;
import eriksommer.webprog.lagringserver.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/lagringserver/")
public class Controller {

    @Autowired
    AppRepository repo;

    @PostMapping("/motor")
    public void lagre(Motorvogn motorvogn) {
        repo.leggInn(motorvogn);
    }

    @GetMapping("/motor")
    public ArrayList<Motorvogn> hent() {
        return repo.hentAlle();
    }

    @DeleteMapping("/motor")
    public void slett() {
        repo.slettAlle();
    }
}
