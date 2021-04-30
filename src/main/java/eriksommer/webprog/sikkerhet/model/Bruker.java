package eriksommer.webprog.sikkerhet.model;

public class Bruker {
    private int id;
    private String brukernavn;
    private String passord;

    public Bruker(int id, String brukernavn, String passord) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.passord = passord;
    }

    public Bruker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
