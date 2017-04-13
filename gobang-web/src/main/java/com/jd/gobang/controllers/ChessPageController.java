package com.jd.gobang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/index", "/", ""})
public class ChessPageController {

    @RequestMapping("chessPage")
    public String chessPage(Model model) {

        return "chessPage";
    }

}
