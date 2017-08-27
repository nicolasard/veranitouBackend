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

@RestController
public class propiedadController {
    
    @CrossOrigin(origins = "*")
    @RequestMapping("/hola")
    public String  echo() {
	return "hola mundo";
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/configuration")
    public String configuracion(){
	return "";
    }
}
