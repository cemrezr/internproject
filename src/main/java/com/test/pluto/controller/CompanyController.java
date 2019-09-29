package com.test.pluto.controller;

import com.test.pluto.dto.CompanyDTO;
import com.test.pluto.facade.CompanyFacade;

import com.test.pluto.model.CompanyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/company")
@RestController
public class CompanyController {

    @Autowired(required = true)
    private CompanyFacade companyFacade;

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    public void setCompanyFacade(CompanyFacade cf) {
        this.companyFacade = cf;
    }

    @GetMapping(value = "", produces = "application/json")
    @ResponseBody
    public List<CompanyDTO> listCompanies() {
        List<CompanyDTO> companyDTOList = companyFacade.listCompanies();
        return companyDTOList;
    }


    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public CompanyDTO addCompanyPost(@RequestBody CompanyDTO companyDTO) {
        this.companyFacade.saveCompany(companyDTO);
        return companyDTO;
    }


    @RequestMapping(value = "",method = RequestMethod.PUT
            ,produces = "application/json",consumes = "application/json")
    @ResponseBody
    public void bulkUpdate(@RequestBody CompanyDTO companyDTO){
        companyFacade.bulkUpdateCompany(companyDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET
            ,produces = "application/json",consumes = "application/json")
    @ResponseBody
    public CompanyDTO getCompanyByID(@PathVariable("id") int id){
        return companyFacade.getCompanyByID(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT
            ,produces = "application/json",consumes = "application/json")
    @ResponseBody
    public CompanyDTO updateCompanyByID(@PathVariable("id") int id,@RequestBody CompanyDTO companyDTO) {
        companyFacade.updateCompany(companyDTO);
        return companyDTO;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void deleteCompany(@PathVariable("id") int id) {
        companyFacade.deleteCompany(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = "application/json")
    @ResponseBody
    public CompanyDTO patchPost(@PathVariable("id") int id, @RequestBody CompanyDTO companyDTO) {
        companyDTO.setId(id);
        companyFacade.atomicUpdateCompany(companyDTO);
        return companyDTO;
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE
            ,produces = "application/json",consumes = "application/json")
    @ResponseBody
    public void deleteAllCompanies(@RequestBody List<CompanyDTO> companyDTOList){
        companyFacade.deleteAllCompany(companyDTOList);
    }

}