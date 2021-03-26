package eriksommer.webprog.generiskedatatyper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobelRegister<T extends Mobel> {
    private final List<T> mobler;

    public MobelRegister() {
        mobler = new ArrayList<>();
    }

    public void addMobel(T mobel) {
        mobler.add(mobel);
    }

    public T getMobel(int nummer) {
        for (T mobel : mobler) {
            if (mobel.getNummer() == nummer)
                return mobel;
        }
        return null;
    }

    public void slettMobel(int nummer) {
        mobler.removeIf(mobel -> mobel.getNummer() == nummer);
    }

    public void skrivUtAlle() {
        for (Mobel mobel : mobler) {
            System.out.println(mobel);
        }
    }

    public void sorter() {
        Collections.sort(mobler);
    }

    public void sorterMedComparator() {
        mobler.sort(new MobelComparator());
    }

    public void sorterBordMedComparator() {
        mobler.sort(new BordComparator());
    }
}
