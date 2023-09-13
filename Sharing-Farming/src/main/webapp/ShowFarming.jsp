<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List" %>
<%@page import="Model.Farming" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
<link rel="stylesheet" type="text/css" href="CSS/Farming.css"/>
<title>管理系统-查看耕种信息</title>
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

<div class="grngzhong">
	<%
		List<Farming> list=(List<Farming>)request.getAttribute("ShowFarming");
	%>
	<h1 class="head">耕种信息</h1>
	<div class="farming_table">
		<table align="center">
			<tr>
				<td>土地编号</td><td>用户编号</td><td>代种人员</td><td>植物编号</td><td>种植天数</td><td>种植类型</td>
			</tr>
			<%
				Farming farming=new Farming();
				for(int i=0;i<list.size();i++){
					farming=list.get(i);
			%>
			<tr>
				<td><%=farming.getLno() %></td>
				<td><%=farming.getUno()%></td>
				<td><%=farming.getAno() %></td>
				<td><%=farming.getPno() %></td>
				<td><%=farming.getFday() %></td>
				<td><%=farming.getFst() %></td>
			</tr>
			<%
				}
			%>
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
