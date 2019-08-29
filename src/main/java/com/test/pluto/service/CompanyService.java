package com.test.pluto.service;

import com.test.pluto.model.CompanyEntity;

import java.util.List;

public interface CompanyService {
    public void updateCompany(CompanyEntity c);

    public void saveCompany(CompanyEntity c);

    public List<CompanyEntity> listCompanies();

    public CompanyEntity getCompanyById(int id);



    public void deleteCompany(CompanyEntity c);

    public void deleteAllCompany(List<CompanyEntity> companyEntityList);
}
