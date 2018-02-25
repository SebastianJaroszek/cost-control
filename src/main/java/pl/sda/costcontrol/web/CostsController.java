package pl.sda.costcontrol.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trutyna
 */
@Controller
public class CostsController {

    @GetMapping(value = "/costs")
    public String costsPage() {
        return "costs";
    }
}
