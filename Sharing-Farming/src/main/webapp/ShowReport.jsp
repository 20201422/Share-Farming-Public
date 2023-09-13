<%@ page import="java.util.Objects" %>
<%@ page import="Model.Report" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: coopskywalker
  Date: 2022/5/29
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Report> list= (List<Report>) request.getAttribute("ShowReport");//得到报告
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String una= (String) session.getAttribute("una");//得到会员名字
    String ust= (String) session.getAttribute("ust");//得到会员状态
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <link rel="stylesheet" type="text/css" href="CSS/ShowReport.css" />
    <title>共享农庄平台-耕种进展报告</title>
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
    <div class="ts">需要联系 Farmer 专家？<a>点击这里</a></div>
</header>

<div class="ShowReport">
    <%
        if(list==null){//如果无报告
    %>
    <div class="ShowReport_Head">
        <h1>暂无报告</h1>
    </div>
    <%
        }else{//有报告
    %>
    <div class="Report">
        <table>
            <thead>
            <th>代种人员</th><th>工作内容</th><th>耕种时间</th><th>工作细节</th>
            </thead>
            <tbody>
            <%
                for (Report report:list){
            %>
            <tr>
                <td><%=report.getAno()%></td>
                <td class="xinxi"><%=report.getWork()%></td>
                <td class="xinxi"><%=report.getDate()%></td>
                <td class="xinxi"><%=report.getDetail()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <%
        }
    %>
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
