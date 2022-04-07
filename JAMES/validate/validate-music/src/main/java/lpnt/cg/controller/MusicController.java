package lpnt.cg.controller;

import lpnt.cg.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

@Controller
public class MusicController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("music", new Music());
        return "/home";
    }

    @PostMapping("/valid")
    public String checkValid(@Valid @ModelAttribute Music music,
                             BindingResult bindingResult,
                             Model model) {
        new Music().validate(music, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "/home";
        } else  {
            model.addAttribute("music", music);
            return "/result";
        }
    }
}
