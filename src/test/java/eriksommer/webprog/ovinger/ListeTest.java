package eriksommer.webprog.ovinger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {

    @Test
    void listetest() {
        Liste liste = new Liste();

        liste.settInn(3);
        liste.settInn(2);
        liste.settInn(10);

        System.out.println(liste.finn(2));

        liste.skrivUt();
        System.out.println();
        System.out.println("Antall noder er: " + liste.antall());

        liste.slettNode(2);

        liste.skrivUt();
        System.out.println();
        System.out.println("Antall noder er: " + liste.antall());
    }
}