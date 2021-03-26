package eriksommer.webprog.generiskedatatyper;

import java.util.Comparator;

public class MobelComparator implements Comparator<Mobel> {

    @Override
    public int compare(Mobel o1, Mobel o2) {

        return ((Mobel) o1).getNavn().compareTo(((Mobel) o2).getNavn());
    }
}
