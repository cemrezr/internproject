package com.test.pluto.dao;


import java.util.List;

import com.test.pluto.model.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().configure("hibernate.cfg.xml").addAnnotatedClass(CompanyEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    @Override
    public void addCompany(CompanyEntity c) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(c);
        logger.info("Company saved successfully, Company Details="+c);
    }

    @Override
    public void updateCompany(CompanyEntity c) {
        Session session = getSessionFactory().openSession();
        //  Session session = this.getSessionFactory().getCurrentSession();
        session.update(c);
        logger.info("Company updated successfully, Company Details="+c);
    }

    @Override
    public List<CompanyEntity> listCompanies() {
        Session session = getSessionFactory().openSession();
        try {
            final List<CompanyEntity> companiesList = session.createQuery("from CompanyEntity ").list();
            return companiesList;
        } finally {
            session.close();
        }
    }

    @Override
    public CompanyEntity getCompanyById(int id) {
        Session session = getSessionFactory().openSession();
        try {
            CompanyEntity company = (CompanyEntity) session.load(CompanyEntity.class, new Integer(id));
            return company;
        } finally {
            session.close();
        }
    }

    @Override
    public void removeCompany(int id) {
       // Session session = this.getSessionFactory().getCurrentSession();
        Session session = getSessionFactory().openSession();
        try {
          final  CompanyEntity c = (CompanyEntity) session.load(CompanyEntity.class, new Integer(id));

        } finally {
    //    if(null != c){
            session.close( ); //session.delete(c)
        }
       // logger.info("Company deleted successfully, company details="+c);

    }
}

