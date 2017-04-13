<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>下棋界面</title>
    <script language="javascript">
    
        // 一个棋盘格子的像素大小
        var CELL_SIZE = 40;
        // 棋子图片和棋盘格子的留空大小
        var BLOCK_SIZE = 5;
        // 棋盘的大小
        var BOARD_SIZE = 15;
        
        // 此时能否落子（控制量）
        var ifValid = true;
        // 落子方
        var player = true;
        // 记录落子信息
        var chessInfo = new Array(BOARD_SIZE);
        // 记录棋盘的格数和字母的关系
        var boardMarkMap = new Array("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O");
        
        // AJAX异步请求对象
        var xmlHttpRequest;
        
        // 整个前端初始化函数
        function init() {
            
            if (window.XMLHttpRequest) {
                // code for all new browsers
                xmlHttpRequest = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                // code for IE5 and IE6
                xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            }
            
            // 新建一个落子记录对象
            for (var i = 0; i < 15; i++) {
                chessInfo[i] = new Array(BOARD_SIZE);
            }
            // 这里调用一个初始化值的函数(简单处理)
            startGame();
            
        }
        
        // 发送请求
        function sendRequest(info, URL) {
            xmlHttpRequest.onreadystatechange = onResponse;
            xmlHttpRequest.open("GET", URL, true);
            xmlHttpRequest.send(info);
        }
        
        // 服务器端回答请求
        function onResponse() {
            if (readyState == 4) {
                if (xmlHttpRequest.status == 200) {
                    // 成功接受数据 AI准备落子
                    
                    alert("成功接受数据:" + xmlHttpRequest.responseText);
                    // 再次等待落子
                    ifValid = true; 
                } else {
                    alert("接受数据失败");
                }
            }
        }
        
        // 用户点击开始/重新开始按钮的时候的操作
        function startGame() {
            
            // 重新刷新棋盘落子信息
            for (var i = 0; i < BOARD_SIZE; i++) {
                for (var j = 0; j < BOARD_SIZE; j++) {
                    chessInfo[i][j] = 0;    
                }
            }
            
            // 刷新页面上所有的落子
            document.getElementById("boardDiv").innerHTML = "";
            // 刷新落子信息面板
            setChessDownInfo("", true);
            
        }
    
        // 用户点击事件
        function userClickOnBoard(e) {
            
            // 获取点击位置并且进行坐标轴转换
            var x = e.clientY;
            var y = e.clientX;
            
            // 点击位置的合法性,能否能落子的判断,判断是否已经落子
            if (x <= CELL_SIZE || y <= CELL_SIZE || ifValid == false) {
                return ;
            }
            
            x = parseInt((x - CELL_SIZE) / CELL_SIZE);
            y = parseInt((y - CELL_SIZE) / CELL_SIZE);
            
            // 如果已经落子
            if (chessInfo[x][y] != 0) {
                return ;
            }
            
            // 有效落子
            userDown(x, y, true);
            // player = !player;
        }
        
        // 用户落子
        function userDown(x, y, player) {
            
            // 禁止连续落子
            ifValid = false;
            
            drawDown(x, y, player);
            
            setChessDownInfo((player ? "黑方" : "白方") + "落子[" + boardMarkMap[x] + (y + 1) + "]", false);
            
            sendRequest(x * 100 + y, "ai/getNextMove");
            
        }
        
        // 画出落子
        function drawDown(x, y, player) {
            
            // 判断黑白
            if (player == true) {
                var pic = "black.jpg\" ";
            } else {
                var pic = "write.jpg\" ";
            }
            
            // 计算坐标
            var top = x * CELL_SIZE + CELL_SIZE + BLOCK_SIZE;
            var left = y * CELL_SIZE + CELL_SIZE + BLOCK_SIZE;
            
            var chessman = "<img src=\"./images/" + pic + "style=\"position:absolute; top:" + top + "px; left:" + left + "px\" >"
            
            // alert(top + "," + left + "," + chessman);
            document.getElementById("boardDiv").innerHTML += chessman;
        }
        
        // 修改落子信息面板显示内容
        function setChessDownInfo(str, ifReset) {
            
            var date = new Date();
            
            if (ifReset) {
                document.getElementById("chessDownInfo").value = str;
            } else {
                document.getElementById("chessDownInfo").value += "[" + date.toLocaleString() + "]" + str + "\n";
            }
        }
    
    </script>
</head>
<body onLoad="init()">

    <!-- 棋盘图片 -->
    <img id="boardImg" style="position:absolute; top:0px; left:0px" src="./images/board.jpg" onClick="userClickOnBoard(event)" alt="棋盘"/>
    <!-- 棋盘div，用于落子-->
    <div id="boardDiv" style="position:absolute; top:0px; left:0px"></div>
    
    <textarea id="chessDownInfo" style="position:absolute; top:100px; left:640px; width:400px; height:300px"></textarea>
    
    <button style="position:absolute; top:0px; left:640px; width:200px; height:100px" onClick="startGame()">重新开始</button>
</body>
</html>