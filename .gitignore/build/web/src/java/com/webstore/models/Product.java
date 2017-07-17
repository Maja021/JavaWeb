
package com.webstore.models;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class Product {
    
     private int id;
     
     @NotEmpty(message = "Name can not be left empty")
     private String name;
     
     @NotNull(message = "Price name can not be left empty")   
     @DecimalMax(value="999999.9999", message = "Max is 999999.9999")
     @DecimalMin(value="1", message = "Min is 1")
     private BigDecimal price;
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(int productId) {
        this.id = productId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
          
	@Override
	public String toString(){
            return "id=" +id+ ", name=" + name + ", price=" + price;
	}
        
        public com.webstore.hibernate.Product ConvertToDao()
        {
            com.webstore.hibernate.Product c = new com.webstore.hibernate.Product();
            
            c.setProductId(id);
            c.setName(name);
            c.setPrice(price);

            return c;
        }
}
