package com.veranitou.controllers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.log4j.Logger;
import com.veranitou.dao.configuration;

import org.hibernate.Session;
import com.veranitou.dao.HibernateUtil;
import com.veranitou.dao.Consulta;

@RestController
public class PropiedadController {
    
    final static Logger logger = Logger.getLogger(PropiedadController.class);

    @CrossOrigin(origins = "*")
    @RequestMapping("/hola")
    public String  echo() {
        logger.info("/hola");
	   return "hola mundo";
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/secure/consultas/lista/")
    public List<Consulta> consultas(
        @RequestParam(value = "qty", required = false) int qty,
        @RequestParam(value = "page", required = false) int page
         ){

        logger.info("/consultas/lista/");
        logger.info("qty= page=");
        int RegistersToSkip = qty*page;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Consulta> consultas = session.createQuery("from Consulta ").setFirstResult(RegistersToSkip).setMaxResults(qty).list();
        session.getTransaction().commit();

	   return consultas;
    }
}