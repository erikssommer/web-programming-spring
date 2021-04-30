package eriksommer.webprog.sikkerhet.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Kryptering {

    private final BCryptPasswordEncoder bCrypt;

    public Kryptering(){
        bCrypt = new BCryptPasswordEncoder(15);
    }

    public String krypterPassord(String passord) {
        return bCrypt.encode(passord);
    }

    public boolean sjekkPassord(String passord, String hashPassord) {

        return bCrypt.matches(passord, hashPassord);
    }
}
