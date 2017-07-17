/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstore.services;

import com.webstore.dao.ProductDAO;
import com.webstore.dao.ProductDAOImplementation;
import com.webstore.models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

public class ProductServiceImplementation implements ProductService{

    private final ProductDAO productDAO = new ProductDAOImplementation();

    @Override
    @Transactional
    public void addProduct(Product c) {
        this.productDAO.addProduct(c.ConvertToDao());
    }

    @Override
    @Transactional
    public void updateProduct(Product c) {
        this.productDAO.updateProduct(c.ConvertToDao());
    }

    @Override
    public List<Product> listProducts() {
        return ConvertDAOToModelList(this.productDAO.listProducts());
    }

    @Override
    public Product getProductById(int id) {
        return ConvertDAOToModel(this.productDAO.getProductById(id));
    }

    @Override
    public void removeProduct(int id) {
        this.productDAO.removeProduct(id);
    }
    
    private Product ConvertDAOToModel(com.webstore.hibernate.Product p)
    {
        Product pp = new Product();
        pp.setId(p.getProductId());
        pp.setName(p.getName());
        pp.setPrice(p.getPrice());
        
        return pp;
    }
    
    private List<Product> ConvertDAOToModelList(List<com.webstore.hibernate.Product> productList)
    {
        List<Product> list = new ArrayList<>();     
        productList.forEach((c) -> {
            list.add(ConvertDAOToModel(c));
        });
        
        return list;
    }
}
