package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//public class GreetingController {
//    @GetMapping("/greeting")
//    public String greeting(@RequestParam String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }
//}
@Controller
public class GreetingController {
    @RequestMapping("/result")
    public String greeting(@RequestParam String hello, Model model) {
        model.addAttribute("hello",hello);
        return "result";
    }
}