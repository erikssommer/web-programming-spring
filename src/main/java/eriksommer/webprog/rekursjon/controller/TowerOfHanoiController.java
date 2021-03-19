package eriksommer.webprog.rekursjon.controller;

import eriksommer.webprog.rekursjon.model.TowerOfHanoi;
import eriksommer.webprog.rekursjon.service.TowerOfHanoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/rekursjon/")
public class TowerOfHanoiController {
    @Autowired
    TowerOfHanoiService service;

    @PostMapping("/hanoi")
    public void solve(TowerOfHanoi toh){
        service.solvTowerOfHanoi(toh.getRings(), toh.getFromRod(), toh.getToRod(), toh.getTmpRod());
    }

    @GetMapping("/hanoi")
    public ArrayList<String> getSolution(){
        return service.getSolution();
    }
}
