package eriksommer.webprog.rekursjon.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TowerOfHanoiService {

    private final ArrayList<String> solution = new ArrayList<>();

    public ArrayList<String> getSolution() {
        return solution;
    }

    public void solvTowerOfHanoi(int rings, int fromRod, int toRod, int tmpRod) {
        if (rings == 1) {
            System.out.println(fromRod + " --> " + toRod);
            solution.add(fromRod + " --> " + toRod);
            return;
        }

        solvTowerOfHanoi(rings - 1, fromRod, tmpRod, toRod);
        System.out.println(fromRod + " --> " + toRod);
        solution.add(fromRod + " --> " + toRod);
        solvTowerOfHanoi(rings - 1, tmpRod, toRod, fromRod);
    }
}
