package com.test.pluto.populator.impl;

import com.test.pluto.dto.CompanyDTO;
import com.test.pluto.model.CompanyEntity;
import com.test.pluto.populator.Populator;
import org.springframework.stereotype.Component;

@Component("defaultCompanyAtomicReversePopulater")
public class DefaultCompanyAtomicReversePopulator implements Populator<CompanyDTO, CompanyEntity> {

    @Override
    public void populate(CompanyDTO source, CompanyEntity target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setSlogan(source.getSlogan());
    }

}
