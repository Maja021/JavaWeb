
package com.webstore.services;

import com.webstore.models.Product;
import java.util.List;

public interface ProductService {
    public void addProduct(Product c);
    public void updateProduct(Product c);
    public List<Product> listProducts();
    public Product getProductById(int id);
    public void removeProduct(int id);
}
