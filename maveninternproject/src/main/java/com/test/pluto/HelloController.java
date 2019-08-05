package com.test.pluto;
import org.springframework.stereotype.Controller;
import  org.springframework.ui.ModelMap;
import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class HelloController {
@RequestMapping (method=RequestMethod.GET)
    public String printHello(ModelMap model){
    /*model.addAttribute("message", "Hello Spring MVC Framework!");
    return "hello"; */
    Configuration configuration = new Configuration();
    configuration.configure();
    Configuration con = new Configuration().configure("com/test/pluto/entities/hibernate.cfg.xml").addAnnotatedClass(CompanyEntity.class);

    SessionFactory factory = configuration.buildSessionFactory();
    Session session = factory.getCurrentSession();
    session.beginTransaction();

    Query query = (Query) session.createQuery("from CompanyEntity ");
    List<CompanyEntity> list =  query.list();
    CompanyEntity companyEntity = (CompanyEntity) list.get(0);

    return "hello";
}
