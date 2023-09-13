<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>

<title>管理系统</title>
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
	<h1 class="welcome">您好！欢迎使用共享农庄管理系统</h1>

<footer class="footer">
    <hr>
    Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
    蒙 ICP备2023001109号
</footer>
</body>
</html>
