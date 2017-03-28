package com.jd.gobang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/index", "/", ""})
public class ChessPageController {

    @RequestMapping("/goHTML")
    public String goHTMl(Model model) {
        
        System.out.println("这是B分支");
        
        return "index";
    }
    
}
