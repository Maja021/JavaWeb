
package com.webstore.dao;

import com.webstore.hibernate.Product;
import java.util.List;

public interface ProductDAO {
   public void addProduct(Product c);
   public void updateProduct(Product c);
   public List<Product> listProducts();
   public Product getProductById(int id);
   public void removeProduct(int id);
}
