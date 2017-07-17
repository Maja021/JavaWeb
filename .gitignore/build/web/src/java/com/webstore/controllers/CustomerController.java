
package com.webstore.controllers;

import com.webstore.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.webstore.services.CustomerService;
import com.webstore.services.CustomerServiceImplementation;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class CustomerController {
    
//    @RequestMapping(value = "/customer", method = RequestMethod.GET)
//    public String printCustomer(ModelMap model) {
//        model.addAttribute("message", "Customers page");
//        return "customer";
//    }

    private final CustomerService customerService = new CustomerServiceImplementation();
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(ModelMap model) {
                model.addAttribute("customer", new Customer());
                return Init(model);
	}
	
	//For add and update customer both
	@RequestMapping(value= "/customer/add", method = RequestMethod.POST)
	public String addCustomers(@ModelAttribute("customer") @Valid Customer c, BindingResult result, ModelMap model){
            
             if (result.hasErrors()) {
                return Init(model);
              }
		
		if(c.getId() == 0){
			//new customer, add it
			this.customerService.addCustomer(c);
		}else{
			//existing customer, call update
			this.customerService.updateCustomer(c);
		}
		
		return "redirect:/customers";
		
	}
    
    @RequestMapping("/customer/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
		
        this.customerService.removeCustomer(id);
        return "redirect:/customers";
    }
 
    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
    
    private String Init(ModelMap model)
    {
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
}
