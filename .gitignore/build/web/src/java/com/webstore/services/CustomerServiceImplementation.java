package com.webstore.services;

import com.webstore.dao.CustomerDAO;
import com.webstore.dao.CustomerDAOImplementation;
import java.util.List;
import javax.transaction.Transactional;
import com.webstore.models.Customer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class CustomerServiceImplementation implements CustomerService{

    private final CustomerDAO customerDAO = new CustomerDAOImplementation();

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        this.customerDAO.addCustomer(c.ConvertToDao());
    }

    @Override
    @Transactional
    public void updateCustomer(Customer c) {
        this.customerDAO.updateCustomer(c.ConvertToDao());
    }

    @Override
    public List<Customer> listCustomers() {
        return ConvertDAOToModelList(this.customerDAO.listCustomers());
    }

    @Override
    public Customer getCustomerById(int id) {
        return ConvertDAOToModel(this.customerDAO.getCustomerById(id));
    }

    @Override
    public void removeCustomer(int id) {
        this.customerDAO.removeCustomer(id);
    }
    
    private Customer ConvertDAOToModel(com.webstore.hibernate.Customer c)
    {
        Customer cc = new Customer();
        cc.setId(c.getCustomerId());
        cc.setFirstName(c.getFirstName());
        cc.setLastName(c.getLastName());
        cc.setEmail(c.getEmail());
        
        Date input = c.getDate();
        cc.setDate(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(input) ));
        
        return cc;
    }
    
    private List<Customer> ConvertDAOToModelList(List<com.webstore.hibernate.Customer> customerList)
    {
        List<Customer> list = new ArrayList<>();     
        customerList.forEach((c) -> {
            list.add(ConvertDAOToModel(c));
        });
        
        return list;
    }
    
}
