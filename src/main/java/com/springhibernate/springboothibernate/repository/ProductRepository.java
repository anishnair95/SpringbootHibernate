package com.springhibernate.springboothibernate.repository;

import com.springhibernate.springboothibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);
    private SessionFactory sessionFactory;

    @Autowired
    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            LOGGER.info("Opening new hibernate session");
            return sessionFactory.openSession();
        }

        return session;
    }

//    public Product save(Product product) {
//        Session session = null;
//        try {
//            session = getSession();
//            session.beginTransaction();
//
//            Integer id = (Integer) session.save(product);
//
//            session.getTransaction().commit();
//            session.close();
//            if(id == null) {
//                LOGGER.info("Unable to save the product!!");
//                return null;
//            }
//
//            LOGGER.info("Product saved successfully!!");
//            product.setId(id);
//            return product;
//        }
//        catch (Exception e) {
//            LOGGER.error("Unable to save the product",e);
//            throw new RuntimeException(e);
//        }
//        finally {
//            LOGGER.info("Session Factory status="+sessionFactory.isOpen());
//            LOGGER.info("Session status="+session.isOpen());
//
//            if(session.isOpen()) {
//                LOGGER.info("Transaction status="+session.getTransaction().getStatus());
//
//            }
//        }
//    }

    @Override
    public Product saveProduct(Product product) {
        Session session = null;
        try {
            session = getSession();

            Integer id = (Integer) session.save(product);

            Product product1= session.get(Product.class, 30);
            product1.setName("ProductUpdate");

            session.update(product1);

            if(id == null) {
                LOGGER.info("Unable to save the product!!");
                return null;
            }

            LOGGER.info("Product saved successfully!!");
            product.setId(id);
            return product;
        }
        catch (Exception e) {
            LOGGER.error("Unable to save the product",e);
            throw new RuntimeException(e);
        }
        finally {
            LOGGER.info("Session Factory status="+sessionFactory.isOpen());
            LOGGER.info("Session status="+session.isOpen());

            if(session.isOpen()) {
                LOGGER.info("Transaction status="+session.getTransaction().getStatus());

            }
        }
    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        try {
            session = getSession();
            String query = "SELECT p from Product p";
            List<Product> productList =  session.createQuery(query).list();
            return productList;
        }
        catch (Exception e) {
            LOGGER.error("Unable to fetch all the product",e);
            throw new RuntimeException(e);
        }
        finally {
            LOGGER.info("Session Factory status="+sessionFactory.isOpen());
            LOGGER.info("Session status="+session.isOpen());

            if(session.isOpen()) {
                LOGGER.info("Transaction status="+session.getTransaction().getStatus());

            }
        }
    }

    @Override
    public String saveAll(List<Product> products) {
        Session session = null;

        try {
            session = getSession();
            for(int i=0; i<products.size() ; i++) {
                session.save(products.get(i));
                if(i%10 == 0) {
                    session.flush();
                    session.clear();
                }

            }

            return "All products saved successfully!!";
        }
        catch (Exception e) {
            LOGGER.error("Unable to save all the product",e);
            throw new RuntimeException(e);
        }
        finally {
            LOGGER.info("Session Factory status="+sessionFactory.isOpen());
            LOGGER.info("Session status="+session.isOpen());

            if(session.isOpen()) {
                LOGGER.info("Transaction status="+session.getTransaction().getStatus());

            }
        }
    }
}
