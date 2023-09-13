<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,Model.Goods" %>
<%@ page import="java.util.Objects" %>
<%
    String una= (String) session.getAttribute("una");//得到会员名字
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String ust= (String) session.getAttribute("ust");//得到会员状态
    List<Goods> goodsList=(List<Goods>)request.getAttribute("ShopCarList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <script type="text/javascript" language="JavaScript" src="Script/ShopCar.js"></script>

    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <link rel="stylesheet" type="text/css" href="CSS/ShopCar.css" />
    <style></style>
</head>
<body>

<header>
    <%
        if(uno==null||uno==""){//未登录
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
        <p><a href="#" onclick="UpdateUrl('/ShowTillServlet')">耕种</a></p>
        <p><a href="#" onclick="UpdateUrl('/GoodsInfomationServlet')">购物</a></p>
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
        <p><a href="javascript:void(0);">购物车</a></p>
        <p><a href="#" onclick="UpdateUrl('/ShowMyTillServlet')">我的耕种</a></p>
        <p><a href="#" onclick="UpdateUrl('/OrdersServlet?Option=2')">我的订单</a></p>
        <p><a href="#" onclick="UpdateUrl('/MyInfo.jsp')">我的信息</a></p>
        <%
            }
        %>
    </nav>
</header>

<%
    int size=0;
    if(goodsList!=null)
        size=goodsList.size();
%>
<script> alertNull(<%=size%>)</script>
<br>
<table  id="tab1"  cellspacing="0" align="center" width="100%">
    <tr ><th>图片</th> <th>商品</th> <th>单价</th> <th>数量</th> <th>操作</th></tr>
    <% for(int i=0;i<size;i++)
    {%>
    <tr >
        <td  align="center"><img src="<%=goodsList.get(i).getLocalUrl()%>" style="width: 50px;height: auto"></td>
        <td name="GoodsName" align="center"><%=goodsList.get(i).getCna()%></td>
        <td name="GoodsCpr" align="center"><%=goodsList.get(i).getCpr()%></td>
        <td align="center">
            <button onclick="oncktest3(this,1)">-</button>
            <input type="text" width="500px" name="currentGoods" id="currentGoods" class="aa"
                   value="<%=goodsList.get(i).getNum()%>" disabled="disabled"  style="width:15px; height:20px;border:none;"/>
            <button class="bot" onclick="oncktest3(this,2)">+</button>
        </td>
        <td  align="center"><input type="checkbox" name="GouXuan" onclick="oncktest2()"/></td>
    </tr>
    <%} %>

</table>
<br>
<br>
<br>
<table width="100%" align="center">
    <tr width="100%" align="center">
        <td>全选:  <input type="checkbox" name="GouXuan" onclick="oncktest1(this)" /></td>
        <td><button id="deleteGoods" onclick="DeleteGoods()">删除所选</button></td>
        <td>已经选择<span id="qqq" onclick="oncktest2()">0</span>件商品</td>
        <td>总价 <span id="ppp" onclick="oncktest2()">0</span>元</td>
        <td><button id="ensureBuy" onclick="DealOrders(<%=ust%>)">结算</button> </td>
    </tr>
</table>


<form name = "formOne" action ="ShopCarServlet" id= "formOneId" mothed= "post" />
<input id= "Cna" type= "hidden" name = "Cna" >
<input id= "DeleteCna" type= "hidden" name = "DeleteCna" >
<input id= "Option" type= "hidden" name = "Option" >
<input id= "NextUrl" type= "hidden" name = "NextUrl" >
</form>
<form name = "formTwo" action ="CreateOrder.jsp" id= "formTwoId" mothed= "post" />
<input id= "GoodsCna" type= "hidden" name = "GoodsCna" >
<input id= "GoodsPrice" type= "hidden" name = "GoodsPrice" >
<input id= "AllNum" type= "hidden" name = "AllNum" >
<input id= "Option2" type= "hidden" name = "Option" >
</form>

<footer style="margin-top:320px;">
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
