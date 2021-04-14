package eriksommer.webprog.relasjonsdatabase2.controller;

import eriksommer.webprog.relasjonsdatabase2.repository.Motorvogn6Repository;
import eriksommer.webprog.relasjonsdatabase2.model.Bil;
import eriksommer.webprog.relasjonsdatabase2.model.Motorvogn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/relasjonsdatabase2/")
public class Motorvogn6Controller {

    @Autowired
    private Motorvogn6Repository rep;

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler(HttpServletResponse response) throws IOException {
        List<Bil> alleBiler = rep.hentAlleBiler();
        if (alleBiler == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
        return alleBiler;
    }

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn motorvogn, HttpServletResponse response) throws IOException {
        if (!rep.lagreMotorvogn(motorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        List<Motorvogn> alleMotorvogner = rep.hentAlleMotorvogner();
        if (alleMotorvogner == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
        return alleMotorvogner;
    }

    @GetMapping("/henteEnMotorvogn")
    public Motorvogn henteEnMotorvogn(int id, HttpServletResponse response) throws IOException {
        Motorvogn enMotorvogn = rep.henteEnMotorvogn(id);
        if (enMotorvogn == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
        return enMotorvogn;
    }

    @PostMapping("/endre")
    public void endre(Motorvogn motorvogn, HttpServletResponse response) throws IOException {
        if (!rep.endreMotorvogn(motorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }

    @DeleteMapping("/slettEnMotorvogn")
    public void slettEnMotorvogn(int personnr, HttpServletResponse response) throws IOException {
        if (!rep.slettEnMotorvogn(personnr)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }

    @DeleteMapping("/slettAlle")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException {
        if (!rep.slettAlleMotorvogner()) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }
}