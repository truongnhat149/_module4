package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
//        private final IProductService productService = new ProductService();


    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String folderUpload;

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm,
                                    @ModelAttribute Product product,
                                    HttpServletRequest request) {
        String folderUploadServer = request.getServletContext().getRealPath("/image/");

        MultipartFile multipartFile = productForm.getFileData();
        String fileName = multipartFile.getOriginalFilename();
        try {
//            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
            File fileLocal = new File(folderUpload + fileName) ;
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileLocal));
            stream.write(multipartFile.getBytes());
            stream.close();

            File fileServer = new File(folderUploadServer + fileName) ;
            BufferedOutputStream streamServer = new BufferedOutputStream(new FileOutputStream(fileServer));
            streamServer.write(multipartFile.getBytes());
            streamServer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        Product product = new Product(productForm.getId(), productForm.getName(),
//                productForm.getDescription(), fileName);
        product.setImage(fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("product", product);
        modelAndView.addObject("fileName",fileName);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
