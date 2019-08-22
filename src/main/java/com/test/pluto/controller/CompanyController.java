package com.test.pluto.controller;

import com.test.pluto.dto.CompanyDTO;
import com.test.pluto.facade.CompanyFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/company")
@Controller
public class CompanyController {


    @Autowired(required = true)
    private CompanyFacade companyFacade;

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);


    public void setCompanyFacade(CompanyFacade cf) {
        this.companyFacade = cf;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        model.addAttribute("companies", this.companyFacade.listCompanies());
        return "companyList";
    }

    //For add and update person both
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCompanyGET(@ModelAttribute("company") CompanyDTO companyDTO) {


        return "companyForm";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompanyPost(@ModelAttribute("company") CompanyDTO companyDTO) {
        this.companyFacade.saveOrUpdateCompany(companyDTO);
        return "redirect:/company";
    }


    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {
        this.companyFacade.removeCompany(id);
        return "redirect:/company";
    }


    //Burada bilgileri companyEntitiye işleyeceğiz.
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCompanyGet(@PathVariable("id") int id, Model model) {
        CompanyDTO companyDTO = companyFacade.getCompanyByID(id);
        model.addAttribute("company", companyDTO);
        return "companyForm";
    }

    //Burada bilgileri alıcaz.
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editCompanyPost(@ModelAttribute("company") CompanyDTO companyDTO) {
        this.companyFacade.saveOrUpdateCompany(companyDTO);
        return "companyForm";
    }

}

