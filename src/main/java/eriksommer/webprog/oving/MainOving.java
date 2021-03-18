package eriksommer.webprog.oving;

import java.util.Vector;

public class MainOving {
    public static void main(String[] args) {
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
