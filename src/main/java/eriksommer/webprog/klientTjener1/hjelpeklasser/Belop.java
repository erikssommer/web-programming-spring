package eriksommer.webprog.klientTjener1.hjelpeklasser;

public class Belop {
    private String sort;
    private double verdi;

    public Belop(String sort, double verdi) {
        this.sort = sort;
        this.verdi = verdi;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public double getVerdi() {
        return verdi;
    }

    public void setVerdi(double verdi) {
        this.verdi = verdi;
    }
}
