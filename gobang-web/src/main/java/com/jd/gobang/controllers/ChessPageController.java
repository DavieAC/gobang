package com.jd.gobang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/index", "/", ""})
public class ChessPageController {

    @RequestMapping("/chessPage")
    public String index(Model model) {
        
        int f = 0;
        
        System.out.println("接受到请求");
        
        return "index";
    }
    
    
}
