<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList,java.util.List,Model.Goods,Model.Order" %>
    <%@ page import="java.util.Objects" %>
    <%
    String una= (String) session.getAttribute("una");//得到会员名字
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String ust= (String) session.getAttribute("ust");//得到会员状态
    List<Order> orderList=(List<Order>)request.getAttribute("orderList");
	List<Goods> orderGoodsList;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>共享农庄平台-订单管理</title>
 <script type="text/javascript" language="JavaScript" src="Script/Order.js"></script>
 <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
 <link rel="stylesheet" type="text/css" href="CSS/Order.css" />

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
        <p><a href="ShowTillServlet">耕种</a></p>

        <%
            if(uno==null|| uno.equals("")){//未登录
        %>
        <p><a href="Login.jsp">购物</a></p>
        <p><a href="Login.jsp">购物车</a></p>
        <p><a href="Login.jsp">我的耕种</a></p>
        <p><a href="Login.jsp">我的订单</a></p>
        <p><a href="Login.jsp">我的信息</a></p>
        <%
        }else{//已登录
        %>
        <p><a href="GoodsInfomationServlet">购物</a></p>
        <p><a href="ShopCarServlet?Option=2">购物车</a></p>
        <p><a href="ShowMyTillServlet">我的耕种</a></p>
        <p><a href="OrdersServlet?Option=2">我的订单</a></p>
        <p><a href="MyInfo.jsp">我的信息</a></p>
        <%
            }
        %>
    </nav>
    <div class="ts">需要售后？<a>点击这里</a></div>
</header>

<div class="order">
    <br>
    <%
        int size=0;
        if(orderList!=null)
            size=orderList.size();
%>
<script>alertNull(<%=size%>);</script>
<%
        for(int i=0;i<size;i++){
    %>
    <div class="ygdd">
        <table>
            <tr> <th>订单编号:</th> <th name="th1"><%=orderList.get(i).getOno() %> </th> <th>商品总价:</th><th><%=orderList.get(i).getPrice()%></th></tr>
            <tr> <th>图片</th> <th>商品&nbsp;&nbsp;</th><th>单价</th><th>数量</th>     </tr>
            <% orderGoodsList=orderList.get(i).getOrderGoodsList();
                for(int j=0;j<orderGoodsList.size();j++){

            %>
            <tr> <td><img src='<%=orderGoodsList.get(j).getLocalUrl()%>' class="tupian"></td>
                <td><%=orderGoodsList.get(j).getCna() %></td>
                <td><%=orderGoodsList.get(j).getCpr() %></td>
                <td><%=orderGoodsList.get(j).getNum() %></td></tr>

            <%}  String pei="";  if(orderList.get(i).getQuHuoFangShi()==1)pei="自提";else pei="邮寄";%>
            <tr><td>收件人：</td><td><%=orderList.get(i).getUName()%>,<%=orderList.get(i).getContact()%></td><td>配送方式：</td><td><%=pei%></td></tr>
            <tr><td >收货地址：</td><td colspan="2"><%=orderList.get(i).getAddress()%></td><td ><button name="btn1" class="btn1" onclick="deleteOrder(this)" >删除</button></td></tr>
        </table>
    </div>
    <br><br>
    <%}%>
    <form name = "formOne" action ="OrdersServlet" id= "formOneId" mothed= "post" />
    <input id= "Ono" type= "hidden" name = "Ono" >
    <input id= "Option" type= "hidden" name = "Option" value="3">
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
