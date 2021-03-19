package eriksommer.webprog.datastrukturer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StakkTest {

    @Test
    void stack() {
        Stakk stakk = new Stakk();

        stakk.push(8);
        stakk.push(7);
        stakk.push(3);

        stakk.skrivUt();

        System.out.println();

        System.out.println(stakk.peek());

        stakk.pop();

        stakk.skrivUt();
    }
}