<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,Model.Goods" %>
<%@ page import="java.util.Objects" %>
<%
String una= (String) session.getAttribute("una");//得到会员名字
String uno= (String) session.getAttribute("uno");//得到会员编号
String ust= (String) session.getAttribute("ust");//得到会员状态
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
 <link rel="stylesheet" type="text/css" href="CSS/Shop.css" />
<title>共享农庄平台-购物</title>
</head>
<script type="text/javascript" language="JavaScript" src="Script/Shop.js"></script>
<script type="text/javascript" language="javascript" src="Script/ScrollHolder.js"></script>
<body>
<header>
    <%
        if(uno==null||uno==""){//未登录
            uno="";
    %>
    <div class="head_welcome">您好，<a href="Login.jsp" class="wa">请登录</a>（支持IPv6访问）</div>
    <%
    }else{//已登录
        if(Objects.equals(ust, "0")){//不是会员
    %>
    <div class="head_welcome">您好,<%=una%>（您还不是会员）&nbsp<a href="logoutServlet" class="wa">[退出]</a></div>
    <input type="hidden" value="<%=uno%>" name="uno">
    <%
    }else{
    %>
    <div class="head_welcome">您好,<%=una%>&nbsp<a href="logoutServlet" class="wa">[退出]</a></div>
    <input type="hidden" value="<%=uno%>" name="uno">
    <%
            }
        }
    %>
    <div class="header">共享农庄平台</div>
    <nav class="menu">
        <p><a href="ShowTillServlet">耕种</a></p>
        <p><a href="javascript:void(0);">购物</a></p>
        <%
            if(uno==null|| uno.equals("")){//未登录
        %>

        <p><a href="Login.jsp">购物车</a></p>
        <p><a href="Login.jsp">我的耕种</a></p>
        <p><a href="Login.jsp">我的订单</a></p>
        <p><a href="Login.jsp">我的信息</a></p>
        <%
        }else{//已登录
        %>

        <p><a href="ShopCarServlet?Option=2">购物车</a></p>
        <p><a href="ShowMyTillServlet">我的耕种</a></p>
        <p><a href="OrdersServlet?Option=2">我的订单</a></p>
        <p><a href="MyInfo.jsp">我的信息</a></p>
        <%
            }
        %>
    </nav>
    <div class="ts">现在选购，享受免费送货，Farmer 专家支持、免息分期等服务。</div>
</header>

<div>
    <%
        List<Goods> goodsList=(List<Goods>)request.getAttribute("goodsList");

        int i=1;
        for(Goods goods:goodsList){
            if((i+3)%4==0){
                out.print("<div class=\"ShowGood\">");
            }
    %>
    <div class="Good">
        <div class="Good_Image">
            <img src='<%=goods.getLocalUrl()%>' class="tupian"/>
        </div>
        <div class="Good_Message">
            <a href="javascript:void(0);" class="goodsHref" onclick="buy('<%=goods.getCna()%>','<%=uno%>')"><%=goods.getCna()%> ></a><br>
            售价：<%=goods.getCpr()%>
        </div>
    </div>
    <%
            if(i%4==0)
                out.print("</div>");
            i++;
        }
    %>
    <form name = "formOne" action ="ShopCarServlet" id= "formOneId" mothed= "post" />
    <input id= "Cna" type= "hidden" name = "Cna" >
    <input id= "Num" type= "hidden" name = "Num" >
    <input id= "Option" type= "hidden" name = "Option" >
    </form>
</div>

<footer>
	<hr>
	<div class="footer-help">
		需要更多帮助？致电 400-820-XXXX。
	</div>
	<div class="footer">
		<p>共享农庄平台采用符合业界标准的加密技术对您提交的信息进行保密。</p>
		<hr>
        Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
        蒙 ICP备2023001109号
	</div>
</footer>
</body>
</html>
