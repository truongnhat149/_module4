package lpnt.controller;

import lpnt.model.Product;
import lpnt.services.IProductService;
import lpnt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService = new ProductService();


    @GetMapping(produces = "application/json;charset=UTF-8")
    public String home(Model model) {
        model.addAttribute("product", productService.findAll());
        return "/index";
    }

    @RequestMapping("/{id}/edit")
    public String edit(
            Model model,
            @PathVariable int id
    ) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("suscess", "Update Suscess");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("suscess", "Delete Suscess");
        return "redirect:/product";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        int id = 0;
        do {
            id = (int) (Math.random() * 10000);
        } while (productService.findById(id) != null);
        product.setId(id);
        productService.save(product);
        redirect.addFlashAttribute("suscess", "Create Suscess");
        return "redirect:/product";
    }

    @RequestMapping("/create")
    public String create(  Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model, RedirectAttributes redirect) {
        List<Product> productSearch = productService.findByName(search);
        System.out.println(productSearch.toArray());
        redirect.addFlashAttribute("search", productSearch.toArray());
        return "redirect:/product";
    }
}
