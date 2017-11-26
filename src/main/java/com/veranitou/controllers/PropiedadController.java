package com.veranitou.controllers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.Query;
import com.veranitou.dao.HibernateUtil;
import com.veranitou.dao.Consulta;

@RestController
public class PropiedadController {
    
    final static Logger logger = Logger.getLogger(PropiedadController.class);

    @CrossOrigin(origins="*")
    @RequestMapping("/secure/consultas/lista/")
    public List<Consulta> consultas(
        @RequestParam(value = "qty", required = false) int qty,
        @RequestParam(value = "page", required = false) int page
         ){

        logger.info("/consultas/lista/");
        //logger.info("qty={} page={}",Integer.toString(qty),Integer.toString(page));
        
        int registersToSkip = qty*(page-1);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //TODO: Usar cryteria
        List<Consulta> consultas = session.createQuery("from Consulta order by consultaId desc")
                                .setFirstResult(registersToSkip)
                                .setMaxResults(qty)
                                .list();
        
        session.getTransaction().commit();

	   return consultas;
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/secure/consultas/cantidad/")
    public Long consultas(){

        logger.info("/consultas/cantidad/");
        //logger.info("qty={} page={}",Integer.toString(qty),Integer.toString(page));
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //TODO: Usar cryteria
        Query query = session.createQuery("select count(*) from Consulta");
        Long count = (Long)query.uniqueResult();
        
        session.getTransaction().commit();

	   return count;
    }
}