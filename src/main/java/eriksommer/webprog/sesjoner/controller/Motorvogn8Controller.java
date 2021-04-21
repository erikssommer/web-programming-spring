package eriksommer.webprog.sesjoner.controller;

import eriksommer.webprog.sesjoner.model.Bil;
import eriksommer.webprog.sesjoner.model.Motorvogn;
import eriksommer.webprog.sesjoner.repository.Motorvogn8Repository;
import eriksommer.webprog.sesjoner.service.Inputvalidering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/sesjoner/")
public class Motorvogn8Controller {
    @Autowired
    private Motorvogn8Repository rep;

    @Autowired
    private HttpSession session;

    private final Logger logger = LoggerFactory.getLogger(Motorvogn8Controller.class);

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
        if ((boolean) session.getAttribute("loggetInn")) {
            List<Motorvogn> alleMotorvogner = rep.hentAlleMotorvogner();
            if (alleMotorvogner == null) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB -prøv igjen senere");
            }
            return alleMotorvogner;
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke vise register: Du er ikke logget inn!");
            return null;
        }
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

    @GetMapping("/loggInn")
    public boolean loggInn(String brukernavn, String passord) {
        if (rep.loggInn(brukernavn, passord)) {
            session.setAttribute("loggetInn", true);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/loggUt")
    public void loggUt() {
        session.setAttribute("loggetInn", false);
    }
}
