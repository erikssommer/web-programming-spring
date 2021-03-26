package eriksommer.webprog.generiskedatatyper;

public class MobelImpl extends Mobel {

    public MobelImpl(String navn, String type, int vekt, int pris, int nummer) {
        super(navn, type, vekt, pris, nummer);
    }

    public String toString() {
        return getNummer() + "_" + getNavn();
    }
}
