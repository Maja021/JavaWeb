
package com.webstore.dao;

import com.webstore.hibernate.Buy;
import com.webstore.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BuyDAOImplementation implements BuyDAO {

    private final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
    
    @Override
    public void buyProduct(Buy c) {
       
       Session session = this.sessionFactory.openSession();
       Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(c);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
}
