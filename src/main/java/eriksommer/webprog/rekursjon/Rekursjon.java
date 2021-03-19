package eriksommer.webprog.rekursjon;

public class Rekursjon {
    public static int fac(int tall) {
        if (tall < 0) {
            return -1;
        }
        if (tall == 0) {
            return 1;
        }
        return tall * fac(tall - 1);
    }

    public static int sum(int tall) {
        if (tall == 1) {
            return 1;
        }
        return tall + sum(tall - 1);
    }

    public static int iterativSum(int tall) {
        int sum = 0;

        for (int i = 0; i <= tall; i++) {
            sum += i;
        }
        return sum;
    }

    public static int binsok(int[] listen, int nokkel, int venstre, int hoyre) {
        if (venstre <= hoyre) {
            int split = (venstre + hoyre) / 2;
            if (listen[split] > nokkel) {
                return binsok(listen, nokkel, venstre, split - 1);
            } else if (listen[split] < nokkel) {
                return binsok(listen, nokkel, split + 1, hoyre);
            } else return split; // Funnet!!
        } else return -1;
    }
}
