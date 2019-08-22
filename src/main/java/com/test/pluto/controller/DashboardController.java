package com.test.pluto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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