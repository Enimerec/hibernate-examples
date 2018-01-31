package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HibernateDao <T> {

    private Class<T> type;

    public HibernateDao(Class<T> type) {
        this.type = type;
    }

    private static final Logger logger = Logger.getLogger(EmployeeDao.class);

    public void deleteById(int id ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction findAllTx = null;

        try {
            findAllTx = session.beginTransaction();

            T item = (T) session.get(type, id);
            session.delete(item);

            findAllTx.commit();
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        finally {
            session.close();
        }
    }
    public void add(T item){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction findAllTx = null;
        try {
            findAllTx = session.beginTransaction();
            session.save(item);
            findAllTx.commit();

        }catch (Exception ex){
            logger.error(ex.getMessage());
            logger.error(ex.getMessage());
        }
        finally {
            session.close();
        }
    }

    public  T findByID(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction findAllTx = null;

        T results = null;

        try {
            findAllTx = session.beginTransaction();
            T item = (T) session.get(type, id);

            findAllTx.commit();
            return  item;

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        finally {
            session.close();
        }
        return null;
    }


    public List<T> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction findAllTx = null;
        List<T> items = new ArrayList<>();

        try {
            findAllTx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(type);
            Root<T> root = query.from(type);
            query.select(root);
            Query<T> q = session.createQuery(query);
            items = q.getResultList();

            findAllTx.commit();

            return items;
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        finally {
            session.close();
        }

        return items;
    }
}
