<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List" %>
<%@page import="Model.User" %>
<%@page import="Model.Farming" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
<link rel="stylesheet" type="text/css" href="CSS/Farming.css"/>
<title>管理系统-审批耕种申请</title>
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
		List<Farming> list=(List<Farming>)request.getAttribute("RegistrationFarming");
	%>
	<h1 class="head">耕种申请</h1>
	<div class="farming_table">
		<table>
			<tr>
				<td>土地编号</td><td>用户编号</td><td>代种人员</td><td>植物编号</td><td>种植天数</td><td>种植类型</td><td>状态</td><td>通过</td><td>驳回</td>
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
				<td>待审核...</td>
				<td><button name="pass" value="pass" onclick="window.location.href='PassFarmingServlet?Fst=<%=farming.getFst() %>&Lno=<%=farming.getLno() %>';">通过</button></td>
				<td><button name="failed" value="failed" onclick="window.location.href='DeleteFarmingServlet?Lno=<%=farming.getLno() %>&Uno=<%=farming.getUno()%>';">驳回</button></td>
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
