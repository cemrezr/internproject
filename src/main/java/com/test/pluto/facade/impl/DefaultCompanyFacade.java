package com.test.pluto.facade.impl;

import com.test.pluto.converter.Converter;
import com.test.pluto.dto.CompanyDTO;
import com.test.pluto.facade.CompanyFacade;
import com.test.pluto.model.CompanyEntity;
import com.test.pluto.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DefaultCompanyFacade implements CompanyFacade {


    @Qualifier("defaultCompanyService")
    @Autowired
    private CompanyService companyService;

    @Qualifier("defaultCompanyConverter")
    @Autowired
    private Converter<CompanyEntity, CompanyDTO> companyConverter;

    @Autowired
    @Qualifier("defaultCompanyReverseConverter")
    private Converter<CompanyDTO, CompanyEntity> companyReverseConverter;


    public Converter<CompanyEntity, CompanyDTO> getCompanyConverter() {
        return companyConverter;
    }


    @Override
    public void removeCompany(int id) {
        companyService.removeCompany(id);
    }

    @Override
    public void saveOrUpdateCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = new CompanyEntity();
       companyEntity=companyReverseConverter.converter(companyDTO);
        companyService.saveOrUpdateCompany(companyEntity);
    }

    @Override
    public List<CompanyDTO> listCompanies() {
        //  List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();
        List<CompanyEntity> companyEntities = companyService.listCompanies();
        List<CompanyDTO> companies=companyConverter.convertAll(companyEntities);
        return companies;

    }

    @Override
    public CompanyDTO getCompanyByID(int id) {
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyEntity companyEntity = companyService.getCompanyById(id);
        companyDTO=companyConverter.converter(companyEntity);
        return companyDTO;
    }
}
