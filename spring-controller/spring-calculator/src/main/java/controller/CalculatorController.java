package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/")
    public String load() {
        return "index";
    }

    @RequestMapping("/calculator")
    public String calculate(Model model,
            @RequestParam(name = "numberOne", defaultValue = "0")
            double numberOne,

            @RequestParam(name = "numberTwo", defaultValue = "0")
            double numberTwo,

            @RequestParam(name = "calculation", defaultValue = "")
            String calcul
            )
    {
        double result = 0;
        switch (calcul) {
            case "Addition(+)" :
                result = numberOne + numberTwo;
                calcul = "Addition";
                break;
            case "Subtraction(-)" :
                result = numberOne - numberTwo;
                calcul = "Subtraction";
                break;
            case "Multiplication(*)":
                result = numberOne * numberTwo;
                calcul = "Multiplication";
                break;
            case "Division(/)":
                if( numberTwo != 0) {
                    result = numberOne / numberTwo;
                } else {
                    model.addAttribute("message", "Division By Zero");
                }
                calcul = "Division";
                break;
        }
        model.addAttribute("numberOne", numberOne);
        model.addAttribute("numberTwo", numberTwo);
        model.addAttribute("calcul", calcul);
        model.addAttribute("result", result);
        return "index";
    }
}
