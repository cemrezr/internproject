package com.test.pluto.dao;

import java.util.List;

import com.test.pluto.model.CompanyEntity;

public interface CompanyDAO {
    public void updateCompany(CompanyEntity c);
   public void saveCompany (CompanyEntity c);
    public List<CompanyEntity> listCompanies();
    public CompanyEntity getCompanyById(int id);
    public void deleteAllCompany(List<CompanyEntity> companyEntityList);
    public void deleteCompany (CompanyEntity c);
}
