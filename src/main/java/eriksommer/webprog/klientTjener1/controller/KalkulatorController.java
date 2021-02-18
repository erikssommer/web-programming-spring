package eriksommer.webprog.klientTjener1.controller;

import eriksommer.webprog.klientTjener1.service.KalkulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/klienttjener1")
public class KalkulatorController {

    @Autowired
    KalkulatorService service;

    private final Logger logger = LoggerFactory.getLogger(KalkulatorController.class);

    @GetMapping("/pluss")
    public double pluss(double tall1, double tall2) {
        try {
            return service.addere(tall1, tall2);
        } catch (Exception e) {
            logger.error("Feil i adderingen : " + e);
            return 0.0;
        }
    }

    @GetMapping("/minus")
    public double minus(double tall1, double tall2) {
        try {
            return service.subtrahere(tall1, tall2);
        } catch (Exception e) {
            logger.error("Feil i subtraksjonen : " + e);
            return 0.0;
        }

    }

    @GetMapping("/gange")
    public double gange(double tall1, double tall2) {
        try {
            return service.multiplisere(tall1, tall2);
        } catch (Exception e) {
            logger.error("Feil i multipliseringen : " + e);
            return 0.0;
        }
    }

    @GetMapping("/dele")
    public double dele(double tall1, double tall2) {
        try {
            return service.dividere(tall1, tall2);
        } catch (Exception e) {
            logger.error("Feil i divideringen : " + e);
            return 0.0;
        }
    }
}
