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

@RequestMapping("/company")
@Controller
public class CompanyController {

    @Autowired(required=true)
    private CompanyService companyService;


    public void setCompanyService(CompanyService cs){
        this.companyService = cs;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        model.addAttribute("companies", this.companyService.listCompanies());
        return "company";
    }

    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute("company") CompanyEntity c){

        if(c.getId() == 0){
            //new person, add it
            this.companyService.addCompany(c);
        }else{
            //existing person, call update
            this.companyService.updateCompany(c);
        }

        return "redirect:/companies";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){

        this.companyService.removeCompany(id);
        return "redirect:/companies";
    }

    @RequestMapping("/edit/{id}")
    public String editCompany(@PathVariable("id") int id, Model model){
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        return "company";
    }

}
  /*  @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework ");

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CompanyEntity.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Query query = (Query) session.createQuery("from CompanyEntity ");
        List<CompanyEntity> list =  query.list();
        model.addAttribute("companies",list);


        return "hello";
    }*/

