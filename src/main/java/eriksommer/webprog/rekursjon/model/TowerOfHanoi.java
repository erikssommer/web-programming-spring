package eriksommer.webprog.rekursjon.model;

public class TowerOfHanoi {
    private int rings;
    private int fromRod;
    private int toRod;
    private int tmpRod;

    public TowerOfHanoi(int rings, int fromRod, int toRod, int tmpRod) {
        this.rings = rings;
        this.fromRod = fromRod;
        this.toRod = toRod;
        this.tmpRod = tmpRod;
    }

    public int getRings() {
        return rings;
    }

    public void setRings(int rings) {
        this.rings = rings;
    }

    public int getFromRod() {
        return fromRod;
    }

    public void setFromRod(int fromRod) {
        this.fromRod = fromRod;
    }

    public int getToRod() {
        return toRod;
    }

    public void setToRod(int toRod) {
        this.toRod = toRod;
    }

    public int getTmpRod() {
        return tmpRod;
    }

    public void setTmpRod(int tmpRod) {
        this.tmpRod = tmpRod;
    }
}
