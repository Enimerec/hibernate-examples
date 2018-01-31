package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Country;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountryDao extends HibernateDao<Country> {


    private static final Logger logger = Logger.getLogger(EmployeeDao.class);

    public CountryDao() {
        super(Country.class);
    }

    public Country findByID(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction findAllTx = null;

        Country results = null;

        try {
            findAllTx = session.beginTransaction();

            results = session.get(Country.class, id);

            findAllTx.commit();
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        finally {
            session.close();
        }
        return results;
    }

}
