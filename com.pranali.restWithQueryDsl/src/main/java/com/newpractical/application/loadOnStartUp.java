package com.newpractical.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loadOnStartUp {

    @RequestMapping(value="/")
    public String getHomepage() {
        return "index.html";
    }
}
