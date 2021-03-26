package eriksommer.webprog.generiskedatatyper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

// Fjerner warning for objekter som klager på at de blir oppdatert, men aldri brukt
@SuppressWarnings("all")
class MobelButikkenTest {

    @Test
    void mobelbutikken() {
        // oppgave 3
        MobelRegister<Mobel> mr = new MobelRegister<>();

        mr.addMobel(new MobelImpl("Sverre", "Stol", 10, 1000, 1));
        mr.addMobel(new MobelImpl("Espen", "Bord", 30, 2000, 2));

        System.out.println(mr.getMobel(1));
        mr.slettMobel(1);
        System.out.println(mr.getMobel(1));

        mr.addMobel(new MobelImpl("Nils", "Bord", 30, 2000, 4));
        mr.addMobel(new MobelImpl("Roger", "Bord", 40, 6655, 3));
        System.out.println("Skal gi et negativt tall: " + mr.getMobel(3).compareTo(mr.getMobel(4)));
        System.out.println("Skal gi et positivt tall: " + mr.getMobel(4).compareTo(mr.getMobel(3)));

        System.out.println("Før sortering: ");
        mr.skrivUtAlle();
        mr.sorter();
        System.out.println("Etter sortering: ");
        mr.skrivUtAlle();

        mr.sorterMedComparator();
        System.out.println("Etter sortering etter navn (med Comparator): ");
        mr.skrivUtAlle();

        // oppgave 4
        MobelRegister<Mobel> mr_bord = new MobelRegister<>();
        mr_bord.addMobel(new Bord("Sverre", "Bord", 10, 1000, 1, 4));
        mr_bord.addMobel(new Bord("Espen", "Bord", 30, 2000, 2, 6));
        mr_bord.addMobel(new Bord("Nils", "Bord", 30, 2000, 4, 3));
        mr_bord.addMobel(new Bord("Roger", "Bord", 40, 6655, 3, 8));
        System.out.println("Usorterte bord: ");
        mr_bord.skrivUtAlle();
        System.out.println("Etter sortering etter antall ben (med Comparator): ");
        mr_bord.sorterBordMedComparator();
        mr_bord.skrivUtAlle();

        // oppgave 5
        List<Bord> bord = new ArrayList<>();
        bord.add(new Bord("Sverre", "Bord", 10, 1000, 1, 4));
        bord.add(new Bord("Espen", "Bord", 30, 2000, 2, 6));
        bord.add(new Bord("Rolf", "Bord", 30, 2000, 4, 3));
        bord.add(new Bord("Roger", "Bord", 40, 6655, 3, 8));

        List<Stol> stoler = new ArrayList<>();
        stoler.add(new Stol("Gunnar", "Stol", 10, 1000, 1));
        stoler.add(new Stol("Morten", "Stol", 30, 2000, 2));
        stoler.add(new Stol("Arnulf", "Stol", 30, 2000, 4));
        stoler.add(new Stol("Hildur", "Stol", 40, 6655, 3));

        MobelButikken.generiskSkrivUtAlle(bord);
        MobelButikken.generiskSkrivUtAlle(stoler);

        // ekstraoppgave 1
        // (tester ArrayList og Vector)
        List<Mobel> mobelliste = new ArrayList<>();
        long startTid = System.nanoTime();
        for (int i = 0; i < 10000000; ++i) {
            mobelliste.add(new MobelImpl("Espen", "Bord", 30, 2000, 4));
        }
        long sluttTid = System.nanoTime();
        long varighet = (sluttTid - startTid) / 1000000;
        System.out.println("Innsetting av ti millioner objekter med ArrayList tok " + varighet + " ms");

        Vector<Mobel> mobelvektor = new Vector<>();
        startTid = System.nanoTime();
        for (int i = 0; i < 10000000; ++i) {
            mobelvektor.add(new MobelImpl("Espen", "Bord", 30, 2000, 4));
        }
        sluttTid = System.nanoTime();
        varighet = (sluttTid - startTid) / 1000000;
        System.out.println("Innsetting av ti millioner objekter med Vector tok " + varighet + " ms");

        startTid = System.nanoTime();
        for (int i = 0; i < 10000000; ++i) {
            mobelliste.get(i);
        }
        sluttTid = System.nanoTime();
        varighet = (sluttTid - startTid) / 1000000;
        System.out.println("Traversering av ti millioner objekter med ArrayList tok " + varighet + " ms");

        startTid = System.nanoTime();
        for (int i = 0; i < 10000000; ++i) {
            mobelvektor.get(i);
        }
        sluttTid = System.nanoTime();
        varighet = (sluttTid - startTid) / 1000000;
        System.out.println("Traversering av ti millioner objekter med Vector tok " + varighet + " ms");
    }
}