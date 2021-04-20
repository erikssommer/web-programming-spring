package eriksommer.webprog.inputvalidering.controller;

import eriksommer.webprog.inputvalidering.model.Bil;
import eriksommer.webprog.inputvalidering.model.Motorvogn;
import eriksommer.webprog.inputvalidering.repository.Motorvogn7Repository;
import eriksommer.webprog.inputvalidering.service.Inputvalidering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/inputvalidering/")
public class Motorvogn7Controller {

    @Autowired
    private Motorvogn7Repository rep;

    private final Logger logger = LoggerFactory.getLogger(Motorvogn7Controller.class);

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
        if (Inputvalidering.validerMotorvognOK(motorvogn, logger)) {
            if (!rep.lagreMotorvogn(motorvogn)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
            }
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Valideringsfeil -prøv igjen senere");
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
        if (Inputvalidering.validerMotorvognOK(motorvogn, logger)) {
            if (!rep.endreMotorvogn(motorvogn)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
            }
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Valideringsfeil -prøv igjen senere");
        }
    }

    @GetMapping("/slettEnMotorvogn")
    public void slettEnMotorvogn(String personnr, HttpServletResponse response) throws IOException {
        if (!rep.slettEnMotorvogn(personnr)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }

    @GetMapping("/slettAlle")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException {
        if (!rep.slettAlleMotorvogner()) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
        }
    }
}
