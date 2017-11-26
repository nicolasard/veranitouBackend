package com.veranitou.controllers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import java.security.Principal;


@Controller
public class HomeController {
    
    final static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/secure/", method = RequestMethod.GET)
    public ModelAndView appHome(){

        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        return model;

    }
}