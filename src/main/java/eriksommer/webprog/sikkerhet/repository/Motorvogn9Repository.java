package eriksommer.webprog.sikkerhet.repository;

import eriksommer.webprog.sikkerhet.model.Bil;
import eriksommer.webprog.sikkerhet.model.Bruker;
import eriksommer.webprog.sikkerhet.model.Motorvogn;
import eriksommer.webprog.sikkerhet.service.Kryptering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("all")
public class Motorvogn9Repository {

    @Autowired
    private Kryptering kryptering;

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn9Repository.class);

    public boolean lagreMotorvogn(Motorvogn m) {
        String sql = "INSERT INTO Motorvogn9 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try {
            db.update(sql, m.getPersonnr(), m.getNavn(), m.getAdresse(), m.getKjennetegn(), m.getMerke(), m.getType());
            return true;
        } catch (Exception e) {
            logger.error("Feil i lagre motorvogn " + e);
            return false;
        }
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn9";
        try {
            return db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
        } catch (Exception e) {
            logger.error("Feil i hent alle motorvogner " + e);
            return null;
        }
    }

    public Motorvogn henteEnMotorvogn(int id) {
        String sql = "SELECT * FROM Motorvogn9 WHERE id=?";
        try {
            List<Motorvogn> enMotorvogn = db.query(sql, new BeanPropertyRowMapper(Motorvogn.class), id);
            return enMotorvogn.get(0);
        } catch (Exception e) {
            logger.error("Feil i hent en motorvogn " + e);
            return null;
        }
    }

    public boolean endreMotorvogn(Motorvogn m) {
        String sql = "UPDATE Motorvogn9 SET personnr=?, navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
        try {
            db.update(sql, m.getPersonnr(), m.getNavn(), m.getAdresse(), m.getKjennetegn(), m.getMerke(), m.getType(), m.getId());
            return true;
        } catch (Exception e) {
            logger.error("Feil i endre en motorvogn " + e);
            return false;
        }
    }

    public boolean slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn9 WHERE personnr=?";
        try {
            db.update(sql, personnr);
            return true;
        } catch (Exception e) {
            logger.error("Feil i slett en motorvogn" + e);
            return false;
        }
    }

    public boolean slettAlleMotorvogner() {
        String sql = "DELETE FROM Motorvogn9";
        try {
            db.update(sql);
            return true;
        } catch (Exception e) {
            logger.error("Feil i slett alle motorvogner" + e);
            return false;
        }
    }

    public List<Bil> hentAlleBiler() {
        String sql = "SELECT * FROM Bil9";
        try {
            return db.query(sql, new BeanPropertyRowMapper(Bil.class));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean loggInn(String brukernavn, String passord) {
        String sql = "SELECT * FROM Bruker9 WHERE brukernavn = ?";
        try {
            List<Bruker> brukere = db.query(sql, new BeanPropertyRowMapper(Bruker.class), brukernavn);
            // evt. flere med samme navn, tar første nedenfor (index = 0)
            if (brukere != null) {
                if (kryptering.sjekkPassord(passord, brukere.get(0).getPassord())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private boolean sjekkPassord(String passord, String hashPassord) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(15);

        return bCrypt.matches(passord, hashPassord);
    }

    public boolean registrerBruker(Bruker bruker) {
        String SQL = "INSERT INTO Bruker9(brukernavn, passord) VALUES(?,?)";
        try {
            String kryptertPassord = kryptering.krypterPassord(bruker.getPassord());
            db.update(SQL, bruker.getBrukernavn(), kryptertPassord);
            return true;
        } catch (Exception e) {
            logger.error("Kunne ikke lage kunde");
            return false;
        }
    }

    private String krypterPassord(String passord) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(15);
        return bCrypt.encode(passord);
    }

    public boolean krypterAllePassord() {
        String sql = "SELECT * from Bruker9";
        String kryptertPassord;
        try {
            List<Bruker> alleBrukere = db.query(sql, new BeanPropertyRowMapper(Bruker.class));
            for (Bruker bruker : alleBrukere) {

                kryptertPassord = kryptering.krypterPassord(bruker.getPassord());

                sql = "UPDATE Bruker9 SET passord=? where id=?";
                db.update(sql, kryptertPassord, bruker.getId());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
