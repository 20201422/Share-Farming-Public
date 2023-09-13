<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List" %>
<%@page import="Model.User" %>
<%@page import="java.util.ArrayList" %>
<script type="text/javascript">
function failed(){
    var qr=confirm("确定要驳回吗？");
    if(qr){
        document.getElementById("failed").submit();
    }
}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="CSS/Home.css"/>
<link rel="stylesheet" type="text/css" href="CSS/RegistApplication.css"/>
<title>管理系统-审批会员申请</title>
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

<div class="shenpi">
	<h1 class="head">会员申请</h1>
	<div class="user_table">
		<table>
			<tr>
				<td>编号</td><td>用户名</td><td>邮箱</td><td>状态</td><td>通过</td><td>驳回</td>
			</tr>
			<%
				List<User> list =new ArrayList<>();
				list=(List<User>)request.getAttribute("RegistrationApplication");
				User user=new User();
				for(int i=0;i<list.size();i++){
					user=list.get(i);
			%>
			<tr>
				<td ><%=user.getUno() %></td>
				<td ><%=user.getUna() %></td>
				<td ><%=user.getUemil() %></td>
				<td>待审核...</td>
				<div class="Check_Form_btn">
					<td>
						<button name="pass" value="pass" class="form-btn" onclick="window.location.href='PassServlet?NO=<%=user.getUno() %>';")>通过</button>
					</td>
				</div>
				<div class="Check_Form_btn">
					<td><button name="failed" value="failed" class="form-btn" onclick="failed()">驳回</button></td>
				</div></tr>
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
