
package com.webstore.controllers;

import com.webstore.models.Buy;
import com.webstore.models.Customer;
import com.webstore.models.Product;
import com.webstore.services.BuyService;
import com.webstore.services.BuyServiceImplementation;
import com.webstore.services.CustomerService;
import com.webstore.services.CustomerServiceImplementation;
import com.webstore.services.ProductService;
import com.webstore.services.ProductServiceImplementation;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuyController {
        private final BuyService buyService = new BuyServiceImplementation();
        private final ProductService productService = new ProductServiceImplementation();
	private final CustomerService customerService = new CustomerServiceImplementation();
        
        private Customer customer = new Customer();
        
	@RequestMapping(value = "/buys", method = RequestMethod.GET)
	public String listCustomers(ModelMap model) {
                List<Customer> customerList = this.customerService.listCustomers();
                model.addAttribute("listCustomers", customerList);          
                model.addAttribute("selectedCustomer", this.customer);
                
                if(this.customer.getId() > 0 &&
                    customerList.stream().anyMatch((c) -> (c.getId() == this.customer.getId()))) {
                    model.addAttribute("customerName", this.customer);
                    model.addAttribute("product", new Product());
                    model.addAttribute("listProducts", this.productService.listProducts());
                }
                
                return "buy";
	}
        
        @RequestMapping(value= "/buy/pay", method = RequestMethod.POST)
	public String addProducts(@ModelAttribute("product") Product p){          
            
            Buy buy = new Buy (this.customer, p);
            
            this.buyService.buyProduct(buy);	
            return "redirect:/buys";	
	}
        
        // /buy/set
        @RequestMapping(value= "/buy/set", method = RequestMethod.POST)
	public String setCustomer(@ModelAttribute("selectedCustomer") Customer customer){            
            this.customer = customerService.getCustomerById(customer.getId());           
            return "redirect:/buys";
	}
        
}
