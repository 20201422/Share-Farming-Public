<%@ page import="Model.Farming" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: coopskywalker
  Date: 2022/5/15
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Farming> list1= (List<Farming>) request.getAttribute("ShowSFarming");//得到自行耕种数组
    List<Farming> list2= (List<Farming>) request.getAttribute("ShowMFarming");//得到托管代种数组
    String una= (String) session.getAttribute("una");//得到会员名字
    String uno= (String) session.getAttribute("uno");//得到会员编号
    String ust= (String) session.getAttribute("ust");//得到会员状态
    String searchcheck= (String) request.getAttribute("search-check");//得到查找状态 0为未找到，1为找到
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
    <link rel="stylesheet" type="text/css" href="CSS/MyTill.css" />
    <title>共享农庄平台-我的耕种</title>
</head>
<script type="text/javascript" language="JavaScript" src="Script/MyTill.js"></script>
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

<input type="hidden" name="searchcheck" id="searchcheck" value="<%=searchcheck%>">
<div class="SearchMyTill">
    <form action="SearchFarmingServlet" onsubmit="return search()">
        <div class="SearchMyTill-form">
            <button type="submit">查询</button>
            <input type="text" placeholder="输入土地名称查询" name="searchlna" id="searchlna">
        </div>
    </form>
</div>
<div class="MyFarming">
    <%
        if(list1.size()==0&&list2.size()==0){//均为空
    %>
    <div class="MyFarming_Head">
        <h1>您暂无耕种的土地</h1>
    </div>
    <%
        }
        if(list1.size()!=0){//有自行耕种的土地
    %>
    <div class="MyFarming_Head">
        <h1>自行耕种</h1>
    </div>
    <div class="MySFarming">
        <table>
            <thead>
            <th>#</th><th>土地编号</th><th>土地名称</th><th>土地面积</th><th>土地价格</th><th>租赁月数</th><th>扣费方式</th>
            <th>土地状态</th><th>更改我的土地</th><th>取消耕种</th>
            </thead>
            <%
                int i=1;
                for(Farming farming:list1){
            %>
            <tbody>
            <tr>
                <td><%=i++%></td>
                <td><%=farming.getLno()%></td>
                <td><%=farming.getLna()%></td>
                <td><%=farming.getLar()%>/亩</td>
                <td>RMB&nbsp<%=farming.getLpr()%>/天</td>
                <td><%=farming.getFday()%>个月</td>
                <td><%=farming.getFtp()%></td>
                <%if(farming.getLst()==1){%>
                <td class="alart">正在审核...</td>
                <%}else if(farming.getLst()==2){%>
                <td><a href="PayServlet?lno=<%=farming.getLno()%>">待支付...</a></td>
                <%}else if(farming.getLst()==3){%>
                <td>正在耕种...</td>
                <%}%>
                <td><button onclick="window.location.href='TillOrder.jsp?name=1&fst=自行耕种&lno=<%=farming.getLno()%>&lna=<%=farming.getLna()%>&lpr=<%=farming.getLpr()%>&lar=<%=farming.getLar()%>&lpo=<%=farming.getLpo()%>';">更改</button></td>
                <td><button onclick="quxiao('<%=farming.getLno()%>','<%=farming.getFst()%>')">取消</button></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
    <%
        }
        if(list2.size()!=0){//有托管代种的土地
    %>
    <div class="MyFarming_Head">
        <h1>托管代种</h1>
    </div>
    <div class="MyMFarming">
        <table>
            <thead>
            <th>#</th><th>土地编号</th><th>土地名称</th><th>土地面积</th><th>土地价格</th><th>耕种植物</th><th>代种人员</th>
            <th>租赁月数</th><th>扣费方式</th><th>土地状态</th><th>查看进展</th><th>更改我的土地</th><th>取消耕种</th>
            </thead>
            <%
                int j=1;
                for(Farming farming:list2){
            %>
            <tbody>
            <tr>
                <td><%=j++%></td>
                <td><%=farming.getLno()%></td>
                <td><%=farming.getLna()%></td>
                <td><%=farming.getLar()%>/亩</td>
                <td>RMB&nbsp<%=farming.getLpr()%>/天</td>
                <td><%=farming.getPna()%></td>
                <%if(!Objects.equals(farming.getAno(), "")){//有代种人员%>
                <td><%=farming.getAno()%></td>
                <%}else{%>
                <td  class="alart">请等待分配</td>
                <%}%>
                <td><%=farming.getFday()%>个月</td>
                <td><%=farming.getFtp()%></td>
                <%if(farming.getLst()==1){%>
                <td class="alart">正在审核...</td>
                <%}else if(farming.getLst()==2){%>
                <td><a href="PayServlet?lno=<%=farming.getLno()%>">待支付...</a></td>
                <%}else if(farming.getLst()==3){%>
                <td>正在耕种...</td>
                <%}%>
                <%if(!Objects.equals(farming.getAno(), "")){//有代种人员%>
                <td><a href="ShowReportServlet?lno=<%=farming.getLno()%>">查看</a></td>
                <%}else{%>
                <td class="alart">还未开始耕种</td>
                <%}%>
                <td><button onclick="window.location.href='TillOrder.jsp?name=1&fst=托管代种&lno=<%=farming.getLno()%>&lna=<%=farming.getLna()%>&lpr=<%=farming.getLpr()%>&lar=<%=farming.getLar()%>&lpo=<%=farming.getLpo()%>';">更改</button></td>
                <td><button onclick="quxiao('<%=farming.getLno()%>','<%=farming.getFst()%>')">取消</button></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
    <%
        }
    %>
    <form id="quxiao" action="DeleteMyTillServlet">
        <input type="hidden" id="qxlno" name="qxlno">
        <input type="hidden" id="qxfst" name="qxfst">
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
