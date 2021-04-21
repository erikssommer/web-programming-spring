package eriksommer.webprog.sesjoner.service;

import eriksommer.webprog.sesjoner.model.Motorvogn;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class Inputvalidering {
    public static boolean validerMotorvognOK(Motorvogn motorvogn, Logger logger) {
        String regexPersonnr = "[0-9]{11}";
        String regexNavn = "[a-zA-ZæøåÆØÅ .\\-]{2,20}";
        String regexAdresse = "[0-9a-zA-ZæøåÆØÅ ,.\\-]{2,30}";
        String regexKjennetegn = "[A-Z][A-Z][0-9]{5}";
        String regexMerke = "[a-zA-ZæøåÆØÅ.\\-]{2,10}";
        String regexType = "[0-9a-zA-ZæøåÆØÅ.\\-]{2,10}";

        boolean personnrOK = motorvogn.getPersonnr().matches(regexPersonnr);
        boolean navnOK = motorvogn.getNavn().matches(regexNavn);
        boolean adresseOK = motorvogn.getAdresse().matches(regexAdresse);
        boolean kjennetegnOK = motorvogn.getKjennetegn().matches(regexKjennetegn);
        boolean merkeOK = motorvogn.getMerke().matches(regexMerke);
        boolean typeOK = motorvogn.getType().matches(regexType);

        if (personnrOK && navnOK && adresseOK && kjennetegnOK && merkeOK && typeOK) {
            return true;
        }else {
            logger.error("Valideringsfeil");
            return false;
        }
    }
}
