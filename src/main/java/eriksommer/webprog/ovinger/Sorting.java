package eriksommer.webprog.ovinger;

import java.util.*;

class Person implements Comparable<Person> {
    private String navn;
    private int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    @Override
    public String toString() {
        return "Person{" +
                "navn='" + navn + '\'' +
                ", alder=" + alder +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.getNavn().compareTo(o.getNavn());
    }
}

public class Sorting {
    public static void main(String[] args) {
        List<Person> liste = new ArrayList<>(Arrays.asList(new Person("Petter", 34), new Person("Ana", 21)));
        System.out.println("Usortert!");
        for (Person person : liste) {
            System.out.println(person);
        }
        //Sortering med comparator
        liste.sort((person1, person2) -> person1.getNavn().compareTo(person2.getNavn()));
        //Sortering med comparable
        Collections.sort(liste);
        System.out.println("Sortert!");
        for (Person person : liste) {
            System.out.println(person);
        }
    }
}
