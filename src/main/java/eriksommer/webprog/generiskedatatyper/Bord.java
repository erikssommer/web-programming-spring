package eriksommer.webprog.generiskedatatyper;

public class Bord extends Mobel {

    private int ben;

    public Bord(String navn, String type, int vekt, int pris, int nummer, int ben) {
        super(navn, type, vekt, pris, nummer);
        this.ben = ben;
    }

    public int getBen() {
        return ben;
    }

    public void setBen(int ben) {
        this.ben = ben;
    }

    @Override
    public String toString() {
        return getNummer() + "_" + getNavn() + "_" + getBen();
    }
}
