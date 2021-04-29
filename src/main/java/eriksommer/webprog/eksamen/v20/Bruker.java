package eriksommer.webprog.eksamen.v20;

public class Bruker {
    private String epost;
    private String passord;

    public Bruker(String epost, String passord) {
        this.epost = epost;
        this.passord = passord;
    }

    public Bruker(){}

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
