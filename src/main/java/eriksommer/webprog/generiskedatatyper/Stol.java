package eriksommer.webprog.generiskedatatyper;

public class Stol extends Mobel {

    public Stol(String navn, String type, int vekt, int pris, int nummer) {
        super(navn, type, vekt, pris, nummer);
    }

    @Override
    public String toString() {
        return getNummer() + "_" + getNavn();
    }
}
