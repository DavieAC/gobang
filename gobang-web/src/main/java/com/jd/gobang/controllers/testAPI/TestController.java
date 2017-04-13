package com.jd.gobang.controllers.testAPI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/test"})
public class TestController {
    
    @RequestMapping("/testShowJSP")
    public String goJSP(Model model) {
        
        System.out.println("收到http请求");
        
        return "test";
    }
    
}
