package com.test.pluto.facade;
import com.test.pluto.dto.CompanyDTO;

import java.util.List;

public interface CompanyFacade {



    public  void  removeCompany (int id);
  public void saveOrUpdateCompany (CompanyDTO companyDTO);
    public List<CompanyDTO> listCompanies();
    public CompanyDTO getCompanyByID(int id);


}
