package vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.model.Dictionary;
import java.util.Map;

@Controller
public class PageTranslate {

    @RequestMapping("/result")
    public String translate(@RequestParam String english, Model model) {
        Dictionary dictionary = new Dictionary();
        Map<String, String> treeWord;
        treeWord = dictionary.getTranslate();
        String res = "";
        if (treeWord.get(english) != null) {
            res = treeWord.get(english);
        } else {
            res = "Khong co trong tu dien";
        }
        model.addAttribute("res", res);
        return "result";
    }
}
