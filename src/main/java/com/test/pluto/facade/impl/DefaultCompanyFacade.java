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

    @Autowired
    @Qualifier("defaultCompanyAtomicReverseConverter")
    private Converter<CompanyDTO, CompanyEntity> companyAtomicReverseConverter;


    public Converter<CompanyEntity, CompanyDTO> getCompanyConverter() {
        return companyConverter;
    }


    @Override
    public void saveCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity = companyReverseConverter.converter(companyDTO);
        companyService.saveCompany(companyEntity);
    }

    @Override
    public void updateCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity = companyReverseConverter.converter(companyDTO);
        companyService.updateCompany(companyEntity);
    }

    @Override
    public List<CompanyDTO> listCompanies() {
        //  List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();
        List<CompanyEntity> companyEntities = companyService.listCompanies();
        List<CompanyDTO> companies = companyConverter.convertAll(companyEntities);
        return companies;

    }

    @Override
    public CompanyDTO getCompanyByID(int id) {
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyEntity companyEntity = companyService.getCompanyById(id);
        companyDTO = companyConverter.converter(companyEntity);
        return companyDTO;
    }

    @Override
    public void deleteCompany(int id) {
        CompanyEntity companyEntity = companyService.getCompanyById(id);
        companyService.deleteCompany(companyEntity);
    }

    @Override
    public void deleteAllCompany(List<CompanyDTO> companyDTOList) {
        List<CompanyEntity> companyEntityList = companyReverseConverter.convertAll(companyDTOList);
        companyService.deleteAllCompany(companyEntityList);

    }


    @Override
    public void atomicUpdateCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = companyService.getCompanyById(companyDTO.getId());
        companyEntity = companyAtomicReverseConverter.converter(companyDTO, companyEntity);
        companyService.updateCompany(companyEntity);
    }

    @Override
    public void bulkUpdateCompany(CompanyDTO companyDTO) {

        List<CompanyDTO> companyDTOList = listCompanies();

        for (CompanyDTO dto : companyDTOList) {
            companyDTO.setId(dto.getId());
            CompanyEntity companyEntity = companyReverseConverter.converter(companyDTO);
            companyService.updateCompany(companyEntity);
        }

    }
}