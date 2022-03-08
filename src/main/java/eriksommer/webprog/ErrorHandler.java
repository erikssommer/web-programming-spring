package eriksommer.webprog;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(){
        return "error";
    }

    public String getErrorPath() {
        return PATH;
    }
}
