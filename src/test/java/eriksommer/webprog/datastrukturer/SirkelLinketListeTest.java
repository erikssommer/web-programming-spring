package eriksommer.webprog.datastrukturer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SirkelLinketListeTest {

    @Test
    void sirkelLinketListe() {
        SirkelLinketListe liste = new SirkelLinketListe();

        liste.leggTilNode(8);
        liste.leggTilNode(7);
        liste.leggTilNode(4);
        liste.leggTilNode(5);
        liste.leggTilNode(3);

        liste.skrivUt();

        System.out.println();

        System.out.println(liste.inneholderNode(7));

        liste.slettNode(7);

        System.out.println(liste.inneholderNode(7));

        liste.skrivUt();

        System.out.println();
    }
}