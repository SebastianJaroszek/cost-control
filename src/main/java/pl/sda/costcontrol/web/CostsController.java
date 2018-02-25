package pl.sda.costcontrol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.costcontrol.bo.CostService;

/**
 * @author trutyna
 */
@Controller
public class CostsController {

    private final CostService service;

    @Autowired
    public CostsController(CostService service) {
        this.service = service;
    }

    @GetMapping(value = "/costs")
    public ModelAndView costsPage() {
        ModelAndView mav = new ModelAndView("costs");
        mav.addObject("costs", service.findCosts());
        return mav;
    }

    @GetMapping(value = "/cost/{id}")
    public ModelAndView costDetail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("costDetail");
        mav.addObject("cost", service.findCostDetails(id));
        return mav;
    }

    @PostMapping(value = "cost/delete")
    public String deleteCost(@RequestParam(name = "costId") String id) {
        service.deleteCost(Long.valueOf(id));
        return "redirect:../costs";
    }
}
