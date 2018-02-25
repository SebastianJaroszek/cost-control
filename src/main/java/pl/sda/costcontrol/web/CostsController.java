package pl.sda.costcontrol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.costcontrol.bo.CostFinder;

/**
 * @author trutyna
 */
@Controller
public class CostsController {

    private final CostFinder finder;

    @Autowired
    public CostsController(CostFinder finder) {
        this.finder = finder;
    }

    @GetMapping(value = "/costs")
    public ModelAndView costsPage() {
        ModelAndView mav = new ModelAndView("costs");
        mav.addObject("costs", finder.findCosts());
        return mav;
    }

    @GetMapping(value = "/cost/{id}")
    public ModelAndView costDetail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("costDetail");
        mav.addObject("cost", finder.findCostDetails(id));
        return mav;
    }
}
