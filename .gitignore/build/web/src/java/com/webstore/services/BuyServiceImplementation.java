
package com.webstore.services;

import com.webstore.dao.BuyDAO;
import com.webstore.dao.BuyDAOImplementation;
import com.webstore.models.Buy;

public class BuyServiceImplementation implements BuyService {
    
    private final BuyDAO buyDAO = new BuyDAOImplementation();
        
    @Override
    public void buyProduct(Buy buy) {
         this.buyDAO.buyProduct(buy.ConvertToDao());
    }
    
}
