package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//
//@Controller
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/customers")
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//}

@Controller
public class CustomerController{
    @Autowired
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

//    @RequestMapping("/save")
//    public ModelAndView save() {
//        ModelAndView modelAndView = new ModelAndView("customers/save.jsp");
//        List<Customer> customers = customerService.findAll();
//        customerService.save(customers);
//        modelAndView.addObject("save", customers);
//        return modelAndView;
//    }
    @RequestMapping("/save")
    public String save(@RequestParam Customer customer, Model model) {
        model.addAttribute("");
        return "list";
    }
}