package com.newpractical.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newpractical.application.model.Product;

@Controller
public class loadOnStartUp {

    @RequestMapping(value="/")
    public String getHomepage() {
        return "index.html";
    }
    
    @RequestMapping(value="/getResult")
    public Product getResult(){
    	return null;
    }
    
}
