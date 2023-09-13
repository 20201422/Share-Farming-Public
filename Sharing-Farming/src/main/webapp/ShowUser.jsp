<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List" %>
<%@page import="Model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
<link rel="stylesheet" type="text/css" href="CSS/User.css"/>
<title>管理系统-查看会员信息</title>
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

<div class="huiyuan">
	<%
		List<User> list=(List<User>)request.getAttribute("ShowUser");
	%>
	<h1 class="head">会员信息</h1>
	<div class="user_table">
		<table align="center">
			<tr>
				<td>编号</td><td>用户名</td><td>邮箱</td><td>状态</td>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
					User user=list.get(i);
			%>
			<tr>
				<td class="uno"><%=user.getUno() %></td>
				<td class="una"><%=user.getUna() %></td>
				<td class="uemil"><%=user.getUemil() %></td>
				<td class="status">会员</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>

<footer>
	<div class="footer">
		<p>共享农庄平台采用符合业界标准的加密技术对您提交的信息进行保密。</p>
		<hr>
		Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
		蒙 ICP备2023001109号
	</div>
</footer>
</body>
</html>
