package eriksommer.webprog.lagringserver.controller;

import eriksommer.webprog.lagringserver.model.Motorvogn;
import eriksommer.webprog.lagringserver.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
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
