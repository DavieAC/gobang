package com.jd.gobang.controllers.testAPI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/test"})
public class TestController {
    
    @ResponseBody
    @RequestMapping("/testGetAIMove")
    public String testGetAIMove(@RequestBody String info) {
        
        
        System.out.println("收到AI计算请求:" + info);
        
        
        
        return "0000";
    }
    
    @RequestMapping("/testShowJSP")
    public String goJSP(Model model) {
        
        System.out.println("收到http请求");
        
        return "test";
    }
    
}
