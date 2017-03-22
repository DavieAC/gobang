package com.jd.gobang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/index", "/", ""})
public class ChessPageController {

    @RequestMapping("/goHTML")
    public String goHTMl(Model model) {
        
        System.out.println("收到http请求");
        
        return "index";
    }
    
    @RequestMapping("/goJSP")
    public String goJSP(Model model) {
        
        System.out.println("收到http请求");
        
        return "cloud";
    }
    
}
