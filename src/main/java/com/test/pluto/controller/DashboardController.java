package com.test.pluto.controller;

import com.test.pluto.model.CompanyEntity;
import com.test.pluto.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class DashboardController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        return "index";
    }

}