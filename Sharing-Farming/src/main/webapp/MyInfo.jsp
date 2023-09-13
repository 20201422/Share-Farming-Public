<%@ page import="Model.User" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String una= (String) session.getAttribute("una");//得到会员名字
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String ust= (String) session.getAttribute("ust");//得到会员状态
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <link rel="stylesheet" type="text/css" href="CSS/MyInfo.css" />
    <title>共享农庄平台-我的信息</title>
    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <script type="text/javascript" src="Script/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="Script/Myinfo.js"></script>
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
        <p><a href="GoodsInfomationServlet">购物</a></p>
        <%
            if(uno==null||uno==""){//未登录
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

<div class="info">
    <div class="Head">
        <h1>修改个人信息</h1>
    </div>
    <span class="errorMsg">
        ${ requestScope.msg }
    </span>
    <div class="xg">
        <form action="changeInfoServlet">
            <label>您的姓名：</label>
            <input class="itxt" type="text" placeholder="姓名:" autocomplete="off"
                   tabindex="1" name="name" id="name" value="${sessionScope.get("user").getUna()}"/>
            <br />
            <br />
            <label>用户密码：</label>
            <input class="itxt" type="password" placeholder="密码:" autocomplete="off"
                   tabindex="1" name="password" id="password" value="${sessionScope.get("user").getUpwd()}"/>
            <br />
            <br />
            <label>电子邮件：</label>
            <input class="itxt" type="text" placeholder="邮箱:" autocomplete="off"
                   tabindex="1" name="email" id="email" value="${sessionScope.get("user").getUemil()}"/>
            <br />
            <br />
            <input type="submit" value="修改" id="sub_btn" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="index.jsp" class="cz">取消修改</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="destroyServlet" class="cz" id="destroy">注销账户</a>
        </form>
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
