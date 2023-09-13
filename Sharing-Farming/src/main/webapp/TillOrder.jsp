<%@ page import="JavaBean.TillOrderBean" %>
<%@ page import="Model.Plant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: coopskywalker
  Date: 2022/5/19
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    TillOrderBean tillOrderBean=new TillOrderBean();

    String una= (String) session.getAttribute("una");//得到会员名字
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String ust= (String) session.getAttribute("ust");//得到会员状态
    String lno= request.getParameter("lno");//得到土地编号
    String lna= request.getParameter("lna");//得到土地名称
    String lpr= request.getParameter("lpr");//得到土地价格
    String lar= request.getParameter("lar");//得到土地面积
    String fst= request.getParameter("fst");//得到耕种类型
    String lpo= request.getParameter("lpo");//得到图片名字
    String name= request.getParameter("name");//得到订单类型

    request.setAttribute("ShowPlant", tillOrderBean.ShowPlant());//展示植物
    List<Plant> list= (List<Plant>) request.getAttribute("ShowPlant");
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <link rel="stylesheet" type="text/css" href="CSS/TillOrder.css" />
    <title>共享农庄平台-我的耕种订单</title>
</head>
<script type="text/javascript" language="JavaScript" src="Script/TillOrder.js"></script>
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
        <p><a href="GoodsInfomationServlet">购物</a></p>
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

<div class="order">
    <div class="checkOrder_Head">
        <h1>请检查您的土地</h1>
    </div>
    <div class="Check">
        <div class="checkOrder">
            <div class="Check_Land_Image">
                <img src="Image/<%=lpo%>"  alt="<%=lna%>">
            </div>
            <div class="Check_Land_Message">
                <%if(fst.equals("自行耕种")){%>
                <h3>耕种类型：自行耕种</h3>
                <%}else{%>
                <h3>耕种类型：托管代种</h3>
                <%}%>
                <h3>土地编号：<%=lno%></h3>
                <h3>土地名称：<%=lna%></h3>
                <h3>土地价格：<%=lpr%>/天</h3>
                <h3>土地面积：<%=lar%>亩</h3>
            </div>
        </div>
        <div class="Check_Form">
            <form action="TillOrderServlet" id="queding">
                <input type="hidden" value="<%=ust%>" id="ust">
                <input type="hidden" value="<%=lno%>" name="lno">
                <input type="hidden" value="<%=fst%>" name="fst">
                <input type="hidden" value="<%=name%>" name="lx">
                <%if(Objects.equals(fst, "托管代种")){%>
                <div class="xialakuang">耕种植物：<select name="pno" class="form-input">
                    <%for(Plant plant:list){%>
                    <option value="<%=plant.getPno()%>"><%=plant.getPna()%></option>
                    <%}%>
                </select></div>
                <%}%>
                耕种月数：<input type="number" min="1" name="fday" class="form-text" value="1">
                <div class="xialakuang">扣款方式：<select name="ftp" class="form-input">
                    <option value="微信支付">微信支付</option><option value="支付宝">支付宝</option>
                    <option value="云闪付">云闪付</option><option value="Apple Pay">Apple Pay</option>
                </select></div>
                <div class="Check_Form_btn">
                    <input type="button" value="确定" class="form-btn" onclick="queding()">
                </div>
            </form>
        </div>
    </div>
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
