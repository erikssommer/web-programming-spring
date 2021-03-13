package eriksommer.webprog.nedtrekkslister.controller;

import eriksommer.webprog.nedtrekkslister.model.Bil;
import eriksommer.webprog.nedtrekkslister.repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/nedtrekkslister/")
public class BilController {
    @Autowired
    BilRepository repo;

    @PostMapping("/bil")
    public void lagre(Bil motorvogn) {
        repo.leggInn(motorvogn);
    }

    @GetMapping("/bil")
    public ArrayList<Bil> hent() {
        return repo.hentAlle();
    }

    @DeleteMapping("/bil")
    public void slett() {
        repo.slettAlle();
    }
}
