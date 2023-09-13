<%@ page import="java.util.List" %>
<%@ page import="Model.Land" %>
<%@ page import="Model.Plant" %>
<%@ page import="Model.Goods" %><%--
  Created by IntelliJ IDEA.
  User: coopskywalker
  Date: 2022/6/5
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Land> list1= (List<Land>) request.getAttribute("Land");//得到土地数组
    List<Plant> list2= (List<Plant>) request.getAttribute("Plant");//得到植物数组
    List<Goods> list3= (List<Goods>) request.getAttribute("Crops");//得到农作物数组
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
    <link rel="stylesheet" type="text/css" href="CSS/AssetManagement.css" />
    <title>管理系统-资产管理</title>
</head>
<body>
<div class="header">
    <div class="title">共享农庄管理系统</div>
    <nav class="menu">
        <p><a href="ShowUserServlet">查看会员信息</a></p>
        <p><a href="RegistrationApplicationServlet">审批会员申请</a></p>
        <p><a href="ShowFarmingServlet">查看耕种信息</a></p>
        <p><a href="RegistrationFarmingServlet">审批耕种申请</a></p>
        <p><a href="ProgressReport.jsp">发送进展报告</a></p>
        <p><a href="AssetManagementServlet">资产管理</a></p>
    </nav>
</div>
<div class="Search">
    <form action="">
        <div class="Search-form">
            <button type="submit">查询</button>
            <input type="text" placeholder="输入名称查询" name="searchna" id="searchna">
        </div>
    </form>
</div>
<div class="Asset">
    <div class="bt">
        <h1>土地 <a href="AddLand.jsp">添加</a></h1>
    </div>
    <div class="table1">
        <table>
            <thead>
            <th>#</th><th>土地编号</th><th>土地名称</th><th>土地图片</th><th>土地面积</th><th>土地价格</th><th>土地信息</th><th>下架</th>
            </thead>
            <%
                int i=1;
                for(Land land:list1){
            %>
            <tbody>
            <tr>
                <td><%=i++%></td>
                <td><%=land.getLno()%></td>
                <td><%=land.getLna()%></td>
                <td><img src="Image/<%=land.getLpo()%>" alt="<%=land.getLna()%>"></td>
                <td><%=land.getLar()%>/亩</td>
                <td>RMB&nbsp<%=land.getLpr()%>/天</td>
                <td><%=land.getLmg()%></td>
                <td><a href="DeleteTillServlet?Lno=<%=land.getLno()%>">下架</a></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
</div>
<div class="Asset">
    <div class="bt">
        <h1>植物 <a href="">添加</a></h1>
    </div>
    <div class="table2">
        <table>
            <thead>
            <th>#</th><th>植物编号</th><th>植物名称</th><th>下架</th>
            </thead>
            <%
                i=1;
                for(Plant plant:list2){
            %>
            <tbody>
            <tr>
                <td><%=i++%></td>
                <td><%=plant.getPno()%></td>
                <td><%=plant.getPna()%></td>
                <td><a href="DeletePlantServlet?Pn0=<%=plant.getPno()%>">下架</a></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
</div>
<div class="Asset">
    <div class="bt">
        <h1>农作物 <a href="">添加</a></h1>
    </div>
    <div class="table3">
        <table>
            <thead>
            <th>#</th><th>农作物名称</th><th>农作物图片</th><th>农作物价格</th><th>农作物数量</th><th>下架</th>
            </thead>
            <%
                i=1;
                for(Goods goods:list3){
            %>
            <tbody>
            <tr>
                <td><%=i++%></td>
                <td><%=goods.getCna()%></td>
                <td><img class="nzwtp" src="<%=goods.getLocalUrl()%>" alt="<%=goods.getCna()%>"></td>
                <td>¥ <%=goods.getCpr()%></td>
                <td><%=goods.getNum()%>斤</td>
                <td><a href="DeleteGoodsServlet?Cna=<%=goods.getCna()%>">下架</a></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
</div>

<footer class="footer">
    <hr>
    Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
    蒙 ICP备2023001109号
</footer>
</body>
</html>
