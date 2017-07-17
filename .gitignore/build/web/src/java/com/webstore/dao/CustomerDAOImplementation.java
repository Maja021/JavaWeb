package com.webstore.dao;

import com.webstore.hibernate.HibernateUtil;
import java.util.List;
import com.webstore.hibernate.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAOImplementation implements CustomerDAO {

    private final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

    @Override
    public void addCustomer(Customer c) {
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
    public void updateCustomer(Customer c) {
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
    public List<Customer> listCustomers() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<Customer> personList = null;

        try {
            tx = session.beginTransaction();
            personList = session.createQuery("from Customer").list();
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
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        Customer c = null;

        try {
            tx = session.beginTransaction();
            c = (Customer) session.get(Customer.class, id);
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
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Customer c = (Customer) session.get(Customer.class, new Integer(id));
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
