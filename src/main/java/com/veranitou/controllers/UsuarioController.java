package com.veranitou.controllers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import java.security.Principal;
import com.veranitou.dao.configuration;

import org.hibernate.Session;
import com.veranitou.dao.HibernateUtil;
import com.veranitou.dao.Consulta;

@Controller
public class UsuarioController {
    
    final static Logger logger = Logger.getLogger(UsuarioController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        model.addObject("appVersion", "asd");

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage(Principal principal) {

        logger.info(principal.getName());
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.addObject("userName",principal.getName());
        model.setViewName("admin");
        return model;

    }

}