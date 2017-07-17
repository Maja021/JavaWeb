package com.webstore.models;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Buy {

    private int buyId;
    private Customer customer;
    private Product product;
    private String number;
    private Date time;

    public Buy() {
    }

    public Buy(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }

    public int getBuyId() {
        return this.buyId;
    }

    public void setBuyId(int buyId) {
        this.buyId = buyId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public com.webstore.hibernate.Buy ConvertToDao() {
        com.webstore.hibernate.Buy b = new com.webstore.hibernate.Buy();

        b.setBuyId(buyId);
        b.setCustomer(customer.ConvertToDao());
        b.setProduct(product.ConvertToDao());
        b.setNumber(UUID.randomUUID().toString());
        
        Calendar cal = Calendar.getInstance(); 
        Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
        
        b.setTime(timestamp);

        return b;
    }
}
