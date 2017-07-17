
package com.webstore.dao;

import com.webstore.hibernate.Product;
import com.webstore.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAOImplementation implements ProductDAO {

    private final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

    @Override
    public void addProduct(Product c) {
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

    @Override
    public void updateProduct(Product c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(c);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> listProducts() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<Product> personList = null;

        try {
            tx = session.beginTransaction();
            personList = session.createQuery("from Product").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return personList;
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        Product c = null;

        try {
            tx = session.beginTransaction();
            c = (Product) session.get(Product.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return c;
    }

    @Override
    public void removeProduct(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Product c = (Product) session.get(Product.class, new Integer(id));
            if (null != c) {
                session.delete(c);
            }
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
