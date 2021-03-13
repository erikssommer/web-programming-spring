package eriksommer.webprog.nedtrekkslister.controller;

import eriksommer.webprog.nedtrekkslister.model.Motorvogn;
import eriksommer.webprog.nedtrekkslister.repository.MotorvognRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/nedtrekkslister/")
public class MotorvognController {

    @Autowired
    MotorvognRepository repo;

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
