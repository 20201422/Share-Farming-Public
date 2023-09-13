<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
<link rel="stylesheet" type="text/css" href="CSS/Report.css"/>
<title>管理系统-发送进展报告</title>
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

<div class="jzbg">
<h1 class="head">进展报告</h1>
<form action="ProgressReportServlet">
    <div class="form">
        <div class="zuo">
            <div class="form_input">土地编号：<input type="text" class="text" name="lno"></div>
            <div class="form_input">耕种作物：<input type="text" class="text" name="plant"></div>
            <div class="form_input">工作编号：<input type="text" class="text" name="ano"></div>
            <div class="form_input">工作事项：<input type="text" class="text" name="work"></div>
            <div class="form_input">工作时间：<input type="text" class="text" name="date"></div>
        </div>
        <div class="you">
            <div>进展情况</div>
            <div class="form_inputs"><textarea name="detail" class="textarea" cols="" rows=""></textarea></div>
        </div>
    </div>
    <div class="form_button"><button type="submit">提交</button></div>
</form>
</div>

<footer class="footer">
    <hr>
    Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
    蒙 ICP备2023001109号
</footer>
</body>
</html>
