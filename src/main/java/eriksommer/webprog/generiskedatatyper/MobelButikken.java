package eriksommer.webprog.generiskedatatyper;

import java.util.List;

public class MobelButikken<T> {
    // oppgave 5
    public static <T> void generiskSkrivUtAlle(List<T> mobler) {
        for (T mobel : mobler) {
            System.out.println(mobel);
        }
    }
}
