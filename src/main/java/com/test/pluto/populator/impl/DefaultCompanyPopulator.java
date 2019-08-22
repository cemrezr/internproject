package com.test.pluto.populator.impl;

import com.test.pluto.dto.CompanyDTO;
import com.test.pluto.model.CompanyEntity;
import com.test.pluto.populator.Populator;
import org.springframework.stereotype.Component;


@Component("defaultCompanyPopulater")
public class DefaultCompanyPopulator implements Populator<CompanyEntity, CompanyDTO> {


    @Override
    public void populate(CompanyEntity source, CompanyDTO target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setSlogan(source.getSlogan());
    }
}


