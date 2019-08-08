package com.test.pluto.dao;
import com.test.pluto.model.CompanyEntity;

import java.util.List;

//import com.test.pluto.model.Company;

public interface CompanyDAO {
    public void addCompany(CompanyEntity c);

    public void updateCompany(CompanyEntity c);
    public List<CompanyEntity> listCompanies();
    public CompanyEntity getCompanyById(int id);
    public void removeCompany(int id);
}
