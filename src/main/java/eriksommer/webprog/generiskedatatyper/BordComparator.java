package eriksommer.webprog.generiskedatatyper;

import java.util.Comparator;

public class BordComparator implements Comparator<Mobel> {

    @Override
    public int compare(Mobel o1, Mobel o2) {
        Bord m1 = (Bord) o1;
        Bord m2 = (Bord) o2;

        return m1.getBen() - m2.getBen();
    }
}
