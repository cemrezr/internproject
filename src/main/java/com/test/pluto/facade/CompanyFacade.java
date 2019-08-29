package com.test.pluto.facade;

import com.test.pluto.dto.CompanyDTO;

import java.util.List;

public interface CompanyFacade {



    public void saveCompany(CompanyDTO companyDTO);

    public void updateCompany(CompanyDTO companyDTO);

    public List<CompanyDTO> listCompanies();

    public CompanyDTO getCompanyByID(int id);

    public void deleteCompany(int id);

    public void atomicUpdateCompany(CompanyDTO companyDTO);

    public void deleteAllCompany (List<CompanyDTO> companyDTOList);

    public void bulkUpdateCompany(CompanyDTO companyDTO);
}


