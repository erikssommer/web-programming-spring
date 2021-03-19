package eriksommer.webprog.datastrukturer;

public class SirkelLinketListe {
    private static class Node {
        private final int verdi;
        private Node neste;

        public Node(int verdi) {
            this.verdi = verdi;
        }
    }

    private Node hode;
    private Node hale;

    public SirkelLinketListe() {
        this.hode = null;
        this.hale = null;
    }

    public void leggTilNode(int verdi){
        Node node = new Node(verdi);

        if (hode == null){
            hode = node;
        }else {
            hale.neste = node;
        }

        hale = node;
        hale.neste = hode;
    }

    public boolean inneholderNode(int verdi){
        Node start = hode;

        if (hode != null){
            do {
                if (start.verdi == verdi){
                    return true;
                }
                start = start.neste;
            }while (start != hode);
        }
        return false;
    }

    public void slettNode(int verdi){
        Node currentNode = hode;

        if (hode != null){
            do {
                Node nextNode = currentNode.neste;
                if (nextNode.verdi == verdi){
                    if (hode == hale){
                        hode = null;
                        hale = null;
                    }else {
                        currentNode.neste = nextNode.neste;
                        if (hode == nextNode){
                            hode = hode.neste;
                        }
                        if (hale == nextNode){
                            hale = currentNode;
                        }
                    }
                    break;
                }
                currentNode = nextNode;
            }while (currentNode != hode);
        }
    }

    public void skrivUt(){
        Node current = hode;

        if (hode != null){
            do {
                System.out.print(current.verdi + " ");
                current = current.neste;
            }while (current != hode);
        }
    }
}
