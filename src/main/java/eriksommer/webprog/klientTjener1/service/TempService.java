package eriksommer.webprog.klientTjener1.service;

import org.springframework.stereotype.Service;

@Service
public class TempService {

    private final Integer[] tempArray = new Integer[]{-3,-2,2,7,12,16,18,17,12,7,3,-2};

    public int getTemp(String mnd){
        return switch (mnd) {
            case "Januar" -> tempArray[0];
            case "Februar" -> tempArray[1];
            case "Mars" -> tempArray[2];
            case "April" -> tempArray[3];
            case "Mai" -> tempArray[4];
            case "Juni" -> tempArray[5];
            case "Juli" -> tempArray[6];
            case "August" -> tempArray[7];
            case "September" -> tempArray[8];
            case "Oktober" -> tempArray[9];
            case "November" -> tempArray[10];
            case "Desember" -> tempArray[11];
            default -> 0;
        };
    }
}
