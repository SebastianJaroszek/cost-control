package pl.sda.costcontrol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.costcontrol.bo.CostFinder;
import pl.sda.costcontrol.bo.CostService;
import pl.sda.costcontrol.dto.CalculatorDto;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.dto.NewCostDto;
import pl.sda.costcontrol.dto.Search;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author trutyna
 */
@Controller
public class CostsController {

    private final CostService service;
    private final CostFinder finder;

    @Autowired
    public CostsController(CostService service, CostFinder finder) {
        this.service = service;
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

    @PostMapping(value = "cost/delete")
    public String deleteCost(@RequestParam(name = "costId") String id) {
        service.deleteCost(Long.valueOf(id));
        return "redirect:../costs";
    }

    @GetMapping(value = "cost/add")
    public String addCost(Model model) {
        model.addAttribute("newCost", new NewCostDto());
        model.addAttribute("action", "add");
        return "edit";
    }

    @PostMapping(value = "cost/add")
    public String saveCost(@ModelAttribute("newCost") NewCostDto form,
                           BindingResult result, Model model) {

        service.saveCost(form);

        return "redirect:../costs";
    }

    @GetMapping(value = "cost/search")
    public String searchCost(Model model) {
        model.addAttribute("newSearch", new Search());
        return "search";
    }

    @PostMapping(value = "cost/search")
    public ModelAndView costsByAmount(@ModelAttribute("newSearch") Search search) {
        ModelAndView mav = new ModelAndView("costs");
        mav.addObject("costs", finder.findCostByCriteria(search));
        mav.addObject("search", new Search());
        return mav;
    }

    @GetMapping(value = "cost/calculate")
    public String calculatorPage(Model model) {
        model.addAttribute("newCalculator", new CalculatorDto());
        return "calculator";
    }

    @PostMapping(value = "cost/calculate")
    public ModelAndView useCalculator(@ModelAttribute("newCalculator") CalculatorDto calculator) {
        ModelAndView mav = new ModelAndView("calculator");
        mav.addObject("result", calculate(calculator));
        mav.addObject("newCalculator", new CalculatorDto());
        return mav;
    }

    private String calculate(CalculatorDto calculator) {
        String result = null;
        switch (calculator.getOperator()) {
            case ("+"): {
                result = calculator.getParametr1().add(calculator.getParametr2()).toPlainString();
                break;
            }
            case ("-"): {
                result = calculator.getParametr1().subtract(calculator.getParametr2()).toPlainString();
                break;
            }
            case ("*"): {
                result = calculator.getParametr1().multiply(calculator.getParametr2()).toPlainString();
                break;
            }
            case ("/"): {
                result = calculator.getParametr1().divide(calculator.getParametr2()).toPlainString();
                break;
            }
            default:
                result = "nie znam tej operacji";
        }
        return result;
    }

    @GetMapping(value = "cost/edit")
    public String editCost(Model model, @RequestParam(name = "costId") Long id) {
        CostDto costDto = finder.findCostDetails(id);
        NewCostDto newCostDto = NewCostDto.builder()
                .id(costDto.getId())
                .name(costDto.getName())
                .amount(costDto.getAmount())
                .date(costDto.getCostDate())
                .type(costDto.getType())
                .build();
        model.addAttribute("newCost", newCostDto);
        model.addAttribute("action", "edit");
        return "edit";
    }

    @PostMapping(value = "cost/edit")
    public ModelAndView editCost(@ModelAttribute("newCost") NewCostDto newCostDto) {
        ModelAndView mav = new ModelAndView("costs");
        if (finder.findCostDetails(newCostDto.getId()) != null) {
            service.deleteCost(newCostDto.getId());
        }
        service.saveCost(newCostDto);
        mav.addObject("costs", finder.findCosts());
        return mav;
    }
}