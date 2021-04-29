package eriksommer.webprog.eksamen.v20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@SuppressWarnings("all")
public class Controller {

    @Autowired
    HttpSession session;

    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/langrenn")
    public boolean lagre(Skiloper skiloper) {
        try {
            String kryptert = krypterPassord(skiloper.getPassord());

            String SQL = "INSERT INTO utover(fornavn,etternavn,klubb,epost,passord) VALUES(?,?,?,?,?)";
            db.update(SQL, skiloper.getFornavn(),
                    skiloper.getEtternavn(),
                    skiloper.getKlubb(),
                    skiloper.getEpost(),
                    kryptert);

            return true;
        } catch (Exception e) {
            System.err.println("Feil i insetting i database");
            return false;
        }
    }

    @GetMapping("/langrenn")
    public List<Skiloper> hent() {
        return null;
    }

    @DeleteMapping("/langrenn")
    public void slett() {

    }

    @PostMapping("/logginn")
    public boolean logginn(Bruker bruker) {
        if (validerBruker(bruker.getEpost(), bruker.getPassord())) {
            session.setAttribute("loggetinn", true);
            return true;
        } else {
            logger.error("Feil i validering av brukernavn eller passord");
            return false;
        }
    }

    @GetMapping("/logginn")
    public boolean logginnfrafor() {
        return (boolean) session.getAttribute("loggetinn");
    }

    private String krypterPassord(String passord) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(15);
        return bCrypt.encode(passord);
    }

    private boolean validerBruker(String epost, String passord) {
        String regExEpost = "a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        String regExPassord = "(?=.*[A-ZÆØÅa-zæøå])(?=.*\\d)[A-ZÆØÅa-zæøå\\d]{6,} ";

        if (epost.matches(regExEpost) && passord.matches(regExPassord)) {
            return true;
        } else {
            return false;
        }
    }
}
