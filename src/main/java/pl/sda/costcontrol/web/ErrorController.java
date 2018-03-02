package pl.sda.costcontrol.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleError(RuntimeException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("msg", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ModelAndView handleErrorIllegalArgument(IllegalArgumentException ex){
        ModelAndView mav = new ModelAndView("errorIllegalArgument");
        mav.addObject("msg", ex.getMessage());
        return mav;
    }

}
