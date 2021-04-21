package eriksommer.webprog.sesjoner.repository;

import eriksommer.webprog.sesjoner.model.Bil;
import eriksommer.webprog.sesjoner.model.Motorvogn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@SuppressWarnings("all")
public class Motorvogn8Repository {

    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(Motorvogn8Repository.class);

    public boolean lagreMotorvogn(Motorvogn m) {
        String sql = "INSERT INTO Motorvogn8 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try {
            db.update(sql, m.getPersonnr(), m.getNavn(), m.getAdresse(), m.getKjennetegn(), m.getMerke(), m.getType());
            return true;
        } catch (Exception e) {
            logger.error("Feil i lagre motorvogn " + e);
            return false;
        }
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn8";
        try {
            List<Motorvogn> list = db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
            list.sort((Comparator.comparing(Motorvogn::getAdresse)));
            return list;
        } catch (Exception e) {
            logger.error("Feil i hent alle motorvogner " + e);
            return null;
        }
    }

    public Motorvogn henteEnMotorvogn(int id) {
        String sql = "SELECT * FROM Motorvogn8 WHERE id=?";
        try {
            List<Motorvogn> enMotorvogn = db.query(sql, new BeanPropertyRowMapper(Motorvogn.class), id);
            return enMotorvogn.get(0);
        } catch (Exception e) {
            logger.error("Feil i hent en motorvogn " + e);
            return null;
        }
    }

    public boolean endreMotorvogn(Motorvogn m) {
        String sql = "UPDATE Motorvogn8 SET personnr=?, navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
        try {
            db.update(sql, m.getPersonnr(), m.getNavn(), m.getAdresse(), m.getKjennetegn(), m.getMerke(), m.getType(), m.getId());
            return true;
        } catch (Exception e) {
            logger.error("Feil i endre en motorvogn " + e);
            return false;
        }
    }

    public boolean slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn8 WHERE personnr=?";
        try {
            db.update(sql, personnr);
            return true;
        } catch (Exception e) {
            logger.error("Feil i slett en motorvogn" + e);
            return false;
        }
    }

    public boolean slettAlleMotorvogner() {
        String sql = "DELETE FROM Motorvogn8";
        try {
            db.update(sql);
            return true;
        } catch (Exception e) {
            logger.error("Feil i slett alle motorvogner" + e);
            return false;
        }
    }

    public List<Bil> hentAlleBiler() {
        String sql = "SELECT * FROM Bil8";
        try {
            return db.query(sql, new BeanPropertyRowMapper(Bil.class));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean loggInn(String brukernavn, String passord) {
        String sql = "SELECT count(*) FROM Bruker8 WHERE brukernavn = ? AND passord = ?";
        try {
            int funnetEnBruker = db.queryForObject(sql, Integer.class, brukernavn, passord);
            if (funnetEnBruker > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
