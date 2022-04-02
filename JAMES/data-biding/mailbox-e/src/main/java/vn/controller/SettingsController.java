package vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.model.EmailSettings;

@Controller
@RequestMapping("/home")
public class SettingsController {

    static EmailSettings emailSettings = new EmailSettings("English", 10, true, "Bth");

    @GetMapping()
    public ModelAndView setUpMail() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("emailSettings", emailSettings);
        return modelAndView;
    }

    @PostMapping("/info")
    public ModelAndView showSettings(EmailSettings emailSettings) {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("emailSettings", emailSettings);
        return modelAndView;
    }

}
