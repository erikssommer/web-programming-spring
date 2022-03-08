package eriksommer.webprog.datastrukturer;

import java.util.LinkedList;

public class LenketListe {

    public Node hode;
    public Node hale;

    public LenketListe() {
        hode = hale = null;
    }

    static final class Node {
        String navn;
        Node forrige;
        Node neste;

        public Node(String navn) {
            this.navn = navn;
        }

        public Node(Node forrige, Node neste) {
            this.forrige = forrige;
            this.neste = neste;
        }
    }

    //Veldig forenklet metode
    public void add(String navn) {
        Node node = new Node(navn);
        if (hale == null) {
            hale = hode = node;
        }
        hale.neste = node;
        hale = node;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        Node node = hode;

        while (node != null) {
            msg.append(node.navn).append(" ");
            node = node.neste;
        }

        return msg.toString();
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Petter");
        linkedList.add("Nina");
        System.out.println(linkedList);

        LenketListe liste = new LenketListe();
        liste.add("Erik");
        liste.add("Lisa");
        liste.add("Ali");

        System.out.println(liste);
    }
}
