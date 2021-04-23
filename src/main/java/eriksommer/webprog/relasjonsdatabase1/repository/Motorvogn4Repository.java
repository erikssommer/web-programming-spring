package eriksommer.webprog.relasjonsdatabase1.repository;

import eriksommer.webprog.relasjonsdatabase1.model.Bil;
import eriksommer.webprog.relasjonsdatabase1.model.Motorvogn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Motorvogn4Repository {

    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(Motorvogn4Repository.class);

    public void lagreMotorvogn(Motorvogn motorvogn) {
        String sql = "INSERT INTO Motorvogn (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        db.update(sql, motorvogn.getPersonnr(), motorvogn.getNavn(), motorvogn.getAdresse(), motorvogn.getKjennetegn(),
                motorvogn.getMerke(), motorvogn.getType());
    }

    public List hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn";
        List<Motorvogn> list = db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
        list.sort(((o1, o2) -> o1.getNavn().compareTo(o2.getNavn())));
        list.sort(((o1, o2) -> o1.getMerke().compareTo(o2.getMerke())));
        return list;
    }

    public void slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn WHERE personnr=?";
        db.update(sql, personnr);
    }

    public void slettAlleMotorvogner() {
        String sql = "DELETE FROM Motorvogn";
        db.update(sql);
    }

    public List<Bil> hentAlleBiler() {
        String sql = "SELECT * FROM Bil";
        return db.query(sql, new BeanPropertyRowMapper(Bil.class));
    }
}
