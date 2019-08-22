package com.test.pluto.dao;

import java.util.List;

import com.test.pluto.model.CompanyEntity;

public interface CompanyDAO {
   public void saveOrUpdateCompany (CompanyEntity c);
    public List<CompanyEntity> listCompanies();
    public CompanyEntity getCompanyById(int id);
    public void removeCompany(int id);
}
