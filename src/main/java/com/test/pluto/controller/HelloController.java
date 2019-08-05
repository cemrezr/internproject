package com.test.pluto.controller;

import com.test.pluto.entities.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/")
@Controller
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework ");

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CompanyEntity.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Query query = (Query) session.createQuery("from CompanyEntity ");
        List<CompanyEntity> list =  query.list();
        model.addAttribute("companies",list);

        return "hello";
    }
}
