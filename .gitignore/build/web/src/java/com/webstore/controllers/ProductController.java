package com.webstore.controllers;

import com.webstore.models.Product;
import com.webstore.services.ProductService;
import com.webstore.services.ProductServiceImplementation;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private final ProductService productService = new ProductServiceImplementation();

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
        model.addAttribute("product", new Product());
        return Init(model);
    }

    //For add and update product both
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProducts(@ModelAttribute("product") @Valid Product p, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return Init(model);
        }

        if (p.getId() == 0) {
            //new product, add it
            this.productService.addProduct(p);
        } else {
            //existing product, call update
            this.productService.updateProduct(p);
        }

        return "redirect:/products";

    }

    @RequestMapping("/product/remove/{id}")
    public String removeProduct(@PathVariable("id") int id) {

        this.productService.removeProduct(id);
        return "redirect:/products";
    }

    @RequestMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

    private String Init(ModelMap model) {
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
}
