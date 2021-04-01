package eriksommer.webprog.relasjonsdatabase1.controller;

import eriksommer.webprog.relasjonsdatabase1.repository.Motorvogn4Repository;
import eriksommer.webprog.relasjonsdatabase1.model.Bil;
import eriksommer.webprog.relasjonsdatabase1.model.Motorvogn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relasjonsdatabase1/")
public class Motorvogn4Controller {

    @Autowired
    private Motorvogn4Repository rep;

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        return rep.hentAlleBiler();
    }

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn motorvogn){
        rep.lagreMotorvogn(motorvogn);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlleMotorvogner(){
        return rep.hentAlleMotorvogner();
    }

    @DeleteMapping("/slettEnMotorvogn")
    public void slettEnMotorvogn(String personnr){
        rep.slettEnMotorvogn(personnr);
    }

    @DeleteMapping("/slettAlle")
    public void slettAlleMotorvogner(){
        rep.slettAlleMotorvogner();
    }
}
