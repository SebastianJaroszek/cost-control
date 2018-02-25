package pl.sda.costcontrol.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trutyna
 */
@Controller
public class MainPageController {

    @GetMapping(value = "/main")
    public String mainPage() {
        return "main";
    }



}
