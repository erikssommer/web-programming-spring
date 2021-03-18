package eriksommer.webprog.oving;

public class Liste {
    private static class Node {
        int verdi;
        Node neste;

        public Node(int verdi) {
            this.verdi = verdi;
        }
    }

    private Node hode = null;
    private Node hale = null;

    public void settInn(int tall) {
        Node node = new Node(tall);

        if (hode == null) {
            hode = node;
            hale = hode;
        } else {
            hale.neste = node;
            hale = hale.neste;
        }
    }

    public void slettNode(int tall){
        if (!finn(tall)) return;

        Node start = hode;
        Node forrige = null;

        if (start == null) return;

        do {
            if (start.verdi == tall){
                assert forrige != null;
                forrige.neste = start.neste;
                start.neste = null;
                break;
            }
            forrige = start;
            start = start.neste;
        }while (start != null);
    }

    public boolean finn(int verdi) {
        Node start = hode;

        do {
            if (start.verdi == verdi){
                return true;
            }
            start = start.neste;
        } while (start != null);

        return false;
    }

    public int antall(){
        int teller = 0;
        Node node = hode;

        if (node == null){
            return teller;
        }
        do {
            teller++;
            node = node.neste;
        }while (node != null);

        return teller;
    }


    public void skrivUt(){
        Node start = hode;
        if (hode == null){
            return;
        }
        do {
            System.out.print(start.verdi + " ");
            start = start.neste;
        }while (start != null);
    }
}
