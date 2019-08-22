package com.test.pluto.service.impl;
import java.util.List;

import com.test.pluto.model.CompanyEntity;
import com.test.pluto.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.pluto.dao.CompanyDAO;


@Service()
class DefaultCompanyService implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    @Transactional
   public void saveOrUpdateCompany (CompanyEntity c){
        this.companyDAO.saveOrUpdateCompany(c);
    }

    @Override
    public List<CompanyEntity> listCompanies() {
        return  this.companyDAO.listCompanies();
    }

    @Override
    @Transactional
    public CompanyEntity getCompanyById(int id) {
        return this.companyDAO.getCompanyById(id);
    }

    @Override
    @Transactional
    public void removeCompany(int id) {
        this.companyDAO.removeCompany(id);
    }
}