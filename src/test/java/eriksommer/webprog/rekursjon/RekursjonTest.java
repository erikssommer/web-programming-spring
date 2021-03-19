package eriksommer.webprog.rekursjon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RekursjonTest {

    @Test
    void fac() {
        assertEquals(Rekursjon.fac(5), 120);
    }

    @Test
    void sum() {
        assertEquals(Rekursjon.sum(10), 55);
    }

    @Test
    void iterativSum() {
        assertEquals(Rekursjon.iterativSum(10), 55);
    }

    @Test
    void binsok() {
        int [] liste = {2,5,6,8,9,23,45,56,64,67,89};
        int nokkel = 56;
        int svar = Rekursjon.binsok(liste, nokkel, 0, liste.length-1);
        int riktigSvar = 7;

        assertEquals(svar, riktigSvar);

        nokkel = 3;

        svar = Rekursjon.binsok(liste, nokkel, 0, liste.length-1);
        riktigSvar = -1;

        assertEquals(svar, riktigSvar);
    }
}