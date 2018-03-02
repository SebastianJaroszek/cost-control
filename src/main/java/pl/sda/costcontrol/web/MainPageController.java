package pl.sda.costcontrol.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * @author trutyna
 */
@Controller
public class MainPageController {

    @GetMapping(value = "/main")
    public ModelAndView mainPage() {
        ModelAndView mov = new ModelAndView("main");
        mov.addObject("firstname", "Sebastian");
        mov.addObject("lastname", "Jaroszek");
        mov.addObject("balance", BigDecimal.ZERO);
        return mov;
    }


}
