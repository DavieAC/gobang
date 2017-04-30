package com.jd.gobang.controllers.testAPI;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gobang.constant.Constant;
import com.gobang.dao.api.interfaces.MoveCache;
import com.gobang.domain.ai.Move;

@Controller
@RequestMapping(value = {"/test"})
public class TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @Resource
    MoveCache moveCache;
    
    @RequestMapping("/testMoveCache")
    public void testMoveCache() {
        logger.info("收到测试落子缓存请求");
        int[][] chessInfo = new int[Constant.BOARD_SIZE][Constant.BOARD_SIZE];
        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                chessInfo[i][j] = (int) ((Math.random() * 10) % 3);
            }
        }
        int i = 1;
        moveCache.insertCachedMove(55, 55, chessInfo);
        
        Move move = moveCache.getCachedMove(chessInfo);
        logger.info("{}, {}", move.getX(), move.getY());
        
        int j = 1;
        moveCache.deleteCachedMove(chessInfo);
    }
    
    @ResponseBody
    @RequestMapping("/testGetAIMove")
    public String testGetAIMove(@RequestBody String info) {
        logger.info("收到AI计算请求:{}", info);
        return "0000";
    }
    
    @RequestMapping("/testShowJSP")
    public String goJSP(Model model) {
        logger.info("收到http请求");
        return "test";
    }
    
}
