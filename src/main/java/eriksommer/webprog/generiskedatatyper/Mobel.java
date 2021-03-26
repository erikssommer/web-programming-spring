package eriksommer.webprog.generiskedatatyper;

public abstract class Mobel implements Comparable<Mobel> {
    private String navn;
    private String type;
    private int vekt;
    private int pris;
    private int nummer;

    public Mobel(String navn, String type, int vekt, int pris, int nummer) {
        this.navn = navn;
        this.type = type;
        this.vekt = vekt;
        this.pris = pris;
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public abstract String toString();

    // oppgave 3
    public int compareTo(Mobel o) {
        return this.getNummer() - ((Mobel) o).getNummer();
    }
}
