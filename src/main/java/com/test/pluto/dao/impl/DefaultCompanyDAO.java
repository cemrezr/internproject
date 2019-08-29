package com.test.pluto.dao.impl;


import com.test.pluto.dao.CompanyDAO;
import com.test.pluto.model.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public class DefaultCompanyDAO implements CompanyDAO {
    private static final Logger logger = LoggerFactory.getLogger(DefaultCompanyDAO.class);

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().configure("hibernate.cfg.xml").addAnnotatedClass(CompanyEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    @Override
    @Transactional
    public void updateCompany(CompanyEntity c) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    @Transactional
    public void saveCompany(CompanyEntity c) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<CompanyEntity> listCompanies() {
        Session session = getSessionFactory().openSession();
        try {
            final List<CompanyEntity> companiesList = session.createQuery("from CompanyEntity where remove=0").list();
            return companiesList;
        } finally {
            session.close();
        }
    }

    @Override
    public CompanyEntity getCompanyById(int id) {
        Session session = getSessionFactory().openSession();
        try {
            CompanyEntity company = (CompanyEntity) session.get(CompanyEntity.class, new Integer(id));
            return company;
        } finally {
            session.close();
        }
    }




    @Override
    @Transactional
    public void deleteCompany(CompanyEntity c) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
        @Override
                @Transactional
        public void deleteAllCompany(List<CompanyEntity> companyEntityList) {
            Session session= getSessionFactory().openSession();
            try{
                session.beginTransaction();
                for(CompanyEntity companyEntity: companyEntityList){
                    session.delete(companyEntity);
                }
                session.getTransaction().commit();


            }catch(PersistenceException persistenceException){
                System.out.println("Can not delete this objection");
            }


            finally {
                session.close();;
            }

        }



    }




