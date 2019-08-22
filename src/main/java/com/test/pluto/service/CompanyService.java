package com.test.pluto.service;

import com.test.pluto.model.CompanyEntity;

import java.util.List;

public interface CompanyService {
   public void saveOrUpdateCompany (CompanyEntity c);
    public List<CompanyEntity> listCompanies();
    public CompanyEntity getCompanyById(int id);
    public void removeCompany(int id);
}
