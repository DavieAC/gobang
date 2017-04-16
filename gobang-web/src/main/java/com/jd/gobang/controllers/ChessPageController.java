package com.jd.gobang.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = {"/index", "/", ""})
public class ChessPageController {

    private static final Logger logger = LoggerFactory.getLogger("com.jd");

    /**
     * 落子响应接口，接受前端传来的JSON化的棋局信息，计算出最佳落子，然后返回给前端
     * 
     * @param chessInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("getAIMove")
    public String getAIMove(@RequestBody String chessInfo) {

        try {
            // 首先还原前端传过来的棋局信息
            int[][] chess = JSON.parseObject(chessInfo, int[][].class);
            // 在这里进行AI运算出最优落子
            
            return "0";
        } catch (Exception e) {
            logger.error("计算AI落子controller层异常,e:{}", e);
            return "";
        }
    }

    /**
     * 下棋界面
     * 
     * @param model
     * @return
     */
    @RequestMapping("chessPage")
    public String chessPage(Model model, HttpServletRequest request) {
        logger.info("有人登陆下棋界面,IP:{}", request.getRemoteAddr());
        return "chessPage";
    }

}
